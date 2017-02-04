package uits.school.service;

import uits.school.domain.UserRoles;
import uits.school.domain.UserRolesDao;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRolesServiceImpl implements UserRolesService {
    
    @Autowired
    private UserRolesDao userRolesDao;

    @Override
    public UserRoles byId(Integer id) {
        return userRolesDao.byId(id);
    }

    @Override
    public Serializable save(UserRoles object) {
        return userRolesDao.save(object);
    }

    @Override
    public void update(UserRoles object) {
        userRolesDao.update(object);
    }

    @Override
    public void delete(UserRoles object) {
        userRolesDao.remove(object);
    }
    
    @Override
    public List<UserRoles> list() {
        return userRolesDao.list();
    }

    @Override
    public List<UserRoles> byUserId(Integer userid) {
        return userRolesDao.byUserId(userid);
    }
    
}
