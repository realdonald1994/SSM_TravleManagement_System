package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.UserInfo;
import cn.itcast.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * presentation layer:user_controller
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * search all user
     * @return
     */
    @RequestMapping("/findAll.do")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> users =  userService.findAll();
        mv.addObject("userList",users);
        mv.setViewName("user-list");
        return mv;
    }

    /**
     * save user
     * @param userInfo
     * @throws Exception
     */
    @RequestMapping("/save.do")
    @PreAuthorize("authentication.principal.username == 'tom'")
    public String save(UserInfo userInfo) throws Exception{
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    /**
     * search user by id
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)int userId) throws Exception{
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(userId);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    /**
     * search available roles by userId
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true)int userId) throws Exception{
        ModelAndView mv = new ModelAndView();
        // search user by id
        UserInfo userInfo = userService.findById(userId);
        //search available roles by userid
        List<Role> otherRoles = userService.findOtherRoles(userId);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }

    /**
     * add role to user
     * @param userId
     * @param roleIds
     * @return
     */
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) int userId,@RequestParam(name = "ids",required = true) int[] roleIds) throws Exception {
        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }
}
