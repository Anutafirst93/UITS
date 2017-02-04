package uits.school.service;

import uits.school.domain.User;
import uits.school.domain.UserDao;
import uits.school.domain.UserRolesDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uits.school.domain.UserRoles;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRolesDao userRolesDao;

    @Override
    public User byId(Integer id) {
        User user = userDao.byId(id);
        user.setUserRole(userRolesDao.byUserId(user.getId()).get(0));
        return user;
    }

    @Override
    @Transactional
    public User byUsername(String name) {
        User user = userDao.byUsername(name);
        user.setUserRole(userRolesDao.byUserId(user.getId()).get(0));
        return user;
    }

    @Override
    public List<User> list() {
        List<User> users = userDao.list();
        for (User u : users) {
            List<UserRoles> roles = userRolesDao.byUserId(u.getId());
            if(!roles.isEmpty())
            u.setUserRole(roles.get(0));
        }
        return users;
    }

    @Override
    public Integer save(User u) {
        return (Integer) userDao.save(u);
    }

    @Override
    public void update(User u) {
        userDao.update(u);
    }

    @Override
    public void delete(User u) {
        userDao.remove(u);
    }
}
