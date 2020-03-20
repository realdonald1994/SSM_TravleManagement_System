package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * presentation layer:permission_controller
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    /**
     * search all authorities
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Permission> permissionList  = permissionService.findAll();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return mv;
    }

    /**
     * save a authority
     * @param permission
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(Permission permission) throws Exception{
        permissionService.save(permission);
        return "redirect:findAll.do";
    }
}
