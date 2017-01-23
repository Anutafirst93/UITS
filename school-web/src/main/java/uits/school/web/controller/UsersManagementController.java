/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uits.school.web.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uits.school.domain.User;
import uits.school.domain.UserDao;
import uits.school.domain.UserRoles;
import uits.school.domain.UserRolesDao;

/**
 *
 * @author Нюта
 */
public class UsersManagementController {
    
    @Autowired       
    private UserDao userDao;
    @Autowired
    private UserRolesDao userRolesDao;
    
    @RequestMapping(value = {"/","/users"}, method = {RequestMethod.GET})
    public ModelAndView getUsersList (){
        ModelAndView model = new ModelAndView();
        //model.addObject("title", "привед кросавчеги");
        model.addObject("users", userDao.list());
        model.setViewName("user/users");
        for(User u :userDao.list()) System.out.println(u);
        return model;
    }
    
    /*@RequestMapping(value = {"/users/edituser/{id}"}, method = {RequestMethod.GET})
    public ModelAndView editUser (@PathVariable("id") Integer id){
        ModelAndView model = new ModelAndView();
        User u = userDao.byId(id);
        model.addObject("user", u);
        model.addObject("userid", u.getId());
        model.addObject("acceptedRoles", );
        model.setViewName("user/user-edit");
//        for(Users u :userDao.userList()) System.out.println(u);
        return model;
    }
    */
//     @RequestMapping(value = {"/users/edituser/{id}"}, method = {RequestMethod.POST})
//    public String saveUser (
//            @PathVariable("id") Integer id,
//            @RequestParam("login") String login,
//            @RequestParam("firstname") String firstname,
//            @RequestParam("lastname") String lastname,
//            @RequestParam("roles") String roles,
//            @RequestParam("email") String email,
//            HttpServletRequest request){
//        User u = null;
//        if(id == 0){
//            u = new User();
//            u.setLogin(request.getParameter("login"));
//            u.setFirstname(request.getParameter("firstname"));
//            u.setLastname(request.getParameter("lastname"));
//             u.setRoles(User.Roles.valueOf(request.getParameter("roles")));
//            u.setEmail(request.getParameter("email"));
//            userDao.addUser(updateUser(u, request));
//        }else{
//            u=userDao.getUser(id);
//            u.setLogin(request.getParameter("login"));
//            u.setFirstname(request.getParameter("firstname"));
//            u.setLastname(request.getParameter("lastname"));
//             u.setRoles(User.Roles.valueOf(request.getParameter("roles")));
//            u.setEmail(request.getParameter("email"));
//            userDao.updateUser(updateUser(u, request));
//        }
//        //set fields
//        return "redirect:/users";
//    }
    
    @RequestMapping(value = {"/users/adduser"}, method = {RequestMethod.GET})
    public ModelAndView addUser (){
        ModelAndView model = new ModelAndView();
        model.setViewName("adduser");
        return model;
    }
    
     @RequestMapping(value = {"/users/adduser"}, method = {RequestMethod.POST})
    public String addUser (
            @RequestParam("id") Integer id,
            @RequestParam("login") String login,
            @RequestParam("pass") String pass,
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("roles") String roles,
            @RequestParam("email") String email,
            HttpServletRequest request){
        User u = null;
            u = new User();
            u.setLogin(request.getParameter("login"));
            u.setPass(request.getParameter("pass"));
            u.setFirstname(request.getParameter("firstname"));
            u.setLastname(request.getParameter("lastname"));
            u.setRoles(User.Roles.valueOf(request.getParameter("roles")));
            u.setEmail(request.getParameter("email"));
            userDao.addUser(u);
        return "redirect:/users";
    }
    
    @RequestMapping(value = "/users/delete/{id}", method = {RequestMethod.GET})
    public String deleteUser(@PathVariable("id")
                                Integer id) {
        userDao.deleteUser(id);
        return "redirect:/users";
    }
    
    private User updateUser (User u, HttpServletRequest request) {
        u.setLogin(request.getParameter("login"));
        u.setFirstname(request.getParameter("firstname"));
        u.setLastname(request.getParameter("lastname"));
        u.setRoles(User.Roles.valueOf(request.getParameter("roles")));
        u.setEmail(request.getParameter("email"));
        return u;
    }
    
}
