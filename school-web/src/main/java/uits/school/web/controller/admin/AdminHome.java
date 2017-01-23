package uits.school.web.controller.admin;

import uits.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author user
 */
@Controller
public class AdminHome {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value={"/admin","/admin/home","/admin/users"})
    @Transactional
    public ModelAndView adminHome(){
        ModelAndView mv = new ModelAndView("admin/home");
        mv.addObject("users", userService.list());
        return mv;
    }
    
}
