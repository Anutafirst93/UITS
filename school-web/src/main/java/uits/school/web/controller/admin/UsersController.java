package uits.school.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uits.school.domain.User;
import uits.school.domain.UserRoles;
import uits.school.service.UserRolesService;
import uits.school.service.UserService;

@Controller
public class UsersController {
    
    @Autowired
    private UserService userService;
    @Autowired
    private UserRolesService userRolesService;
    
    @Transactional
    @RequestMapping(value = "/admin/user/{id}", method = RequestMethod.GET)
    public ModelAndView getSelectedUser(@PathVariable("id") Integer id){
        ModelAndView mv = new ModelAndView("admin/user/user-edit");
        mv.addObject("user", userService.byId(id));
        mv.addObject("roles", UserRoles.Roles.values());
        return mv;
    }
    
    @Transactional
    @RequestMapping(value = "/admin/user/{id}", method = RequestMethod.POST)
    public String saveSelectedUser(@PathVariable("id") Integer id,
            @RequestParam(name = "firstname") String firstname,
            @RequestParam(name = "lastname") String lastname,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "phone") String phone,
            @RequestParam(name = "role") String role){
        User user = userService.byId(id);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        UserRoles r = user.getUserRole();
        r.setRolename(UserRoles.Roles.valueOf(role));
        userRolesService.update(r);
        user.setUserRole(r);
        user.setEmail(email);
        user.setPhone(phone);
        user.setActive(true);
        userService.update(user);
        
        return "redirect:/admin/home";
    }
    
    @RequestMapping(value = "/admin/user/add", method = RequestMethod.GET)
    public ModelAndView getAddUserForm(){
        ModelAndView mv = new ModelAndView("admin/user/user-edit");
        mv.addObject("roles", UserRoles.Roles.values());
        return mv;
    }
    
    @Transactional
    @RequestMapping(value = "/admin/user/add", method = RequestMethod.POST)
    public String saveNewUser(
            @RequestParam(name = "firstname") String firstname,
            @RequestParam(name = "lastname") String lastname,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "phone") String phone,
            @RequestParam(name = "role") String role){
        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setPhone(phone);
        //add fields to a new form
        user.setPassword(phone);
        user.setUsername(firstname);
        
        user.setActive(true);
        UserRoles r = new UserRoles();
        r.setRolename(UserRoles.Roles.valueOf(role));
        userService.save(user);
        r.setIduser(user.getId());
        userRolesService.save(r);
        
        
        return "redirect:/admin/home";
    }
    
    
    private boolean getStateSelected(String state){
        return state.equalsIgnoreCase("checked");
    }
    
}
