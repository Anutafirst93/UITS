package uits.school.domain;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserDaoImpl extends AbstractDao<User, Integer> implements UserDao {

    @Override
    @Transactional
    public User byUsername(String name) {
        return (User) getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("username", name)).uniqueResult();
    }
}
