package uits.school.domain;

import java.util.List;
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

    @Override
    public List<User> ListStudentsByGroupId(Integer id) {
        return getCurrentSession().createSQLQuery("SELECT * FROM `user` where id in "
                + "(select id_student from students_list where id_group = :id)").addEntity(User.class)
                .setParameter("id", id).list();
    }
}
