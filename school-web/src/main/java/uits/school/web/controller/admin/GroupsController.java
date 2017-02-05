package uits.school.web.controller.admin;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uits.school.domain.GroupTime;
import uits.school.domain.Groups;
import uits.school.domain.GroupsDao;
import uits.school.domain.User;
import uits.school.domain.UserDao;

@Controller
public class GroupsController {
    
    @Autowired
    private GroupsDao groupsDao;
    
    @Autowired
    private UserDao userDao;
    
    @Transactional
    @RequestMapping(value = "/admin/groups")
    public ModelAndView getGroupsList(){
        //get groups list
        //for each group get teacher
        
        List<Groups> groupsList = groupsDao.list();
        
        ModelAndView mv = new ModelAndView("admin/groups/home");
        List<GroupsModel> model = new ArrayList();
        for(Groups g : groupsList){
            model.add(new GroupsModel(g));
        }
        mv.addObject("groups", model);
        
        return mv;
    }
    
    @Transactional
    @RequestMapping(value = "/admin/groups/{id}")
    public ModelAndView viewSelectedGroup(@PathVariable("id") Integer id){
        //get groups list
        //for each group get teacher
        
        Groups group = groupsDao.byId(id);
        
        List<User> students = userDao.ListStudentsByGroupId(id);
        
//        List<Groups> groupsList = groupsDao.list();
//        
        ModelAndView mv = new ModelAndView("admin/groups/view");
//        List<GroupsModel> model = new ArrayList();
//        for(Groups g : groupsList){
//            model.add(new GroupsModel(g));
//        }
        mv.addObject("group", new GroupsModel(group));
        mv.addObject("students", students);
        
        return mv;
    }
    
    public class GroupsModel{
        private Integer id;
        private String name;
        private String teacherName;
        private List<String> days;

        public GroupsModel(Groups group) {
            days = new ArrayList<>();
            this.id = group.getId();
            this.name = group.getName();
            teacherName = "test";
            for(GroupTime t : group.getGroupTimeList()){
                days.add(t.getDayOfWeek() + " " + t.getStartTime() );
            }
        }
        
        

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTeacherName() {
            return teacherName;
        }

        public void setTeacherName(String teacherName) {
            this.teacherName = teacherName;
        }

        public List<String> getDays() {
            return days;
        }

        public void setDays(List<String> days) {
            this.days = days;
        }
        
    }
    
}
