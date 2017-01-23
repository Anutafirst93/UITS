package uits.school.service;

import uits.school.domain.User;
import uits.school.domain.UserDao;
import uits.school.domain.UserRolesDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRolesDao userRolesDao;

    @Override
    public User byId(Integer id) {
        return userDao.byId(id);
    }

    @Override
    @Transactional
    public User byUsername(String name) {
        User user = userDao.byUsername(name);
        user.setUserRolesList(userRolesDao.byUserId(user.getId()));
        return user;
    }

    @Override
    public List<User> list() {
        List<User> users = userDao.list();
        /*for (User u : users) {
            u.setUserRolesList(userRolesDao.byUserId(u.getId()));
        }*/
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
