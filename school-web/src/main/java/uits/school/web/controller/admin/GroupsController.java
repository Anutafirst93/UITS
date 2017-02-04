package uits.school.web.controller.admin;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uits.school.domain.Groups;
import uits.school.domain.GroupsDao;

@Controller
public class GroupsController {
    
    @Autowired
    private GroupsDao groupsDao;
    
    @Transactional
    @RequestMapping(value = "/admin/groups")
    public ModelAndView getGroupsList(){
        //get groups list
        //for each group get teacher
        
        List<Groups> groupsList = groupsDao.list();
        
        ModelAndView mv = new ModelAndView("admin/groups/home");
        mv.addObject("groups", groupsList);
        
        return mv;
    }
    
}
