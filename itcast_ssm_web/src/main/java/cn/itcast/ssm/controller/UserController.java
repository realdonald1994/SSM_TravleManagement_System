package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.UserInfo;
import cn.itcast.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
