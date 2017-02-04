package uits.school.domain;

import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

@Component
public class UserRolesDaoImpl extends AbstractDao<UserRoles, Integer> implements UserRolesDao{

    @Override
    public List<UserRoles> byUserId(Integer userid) {
        return (List<UserRoles>)getCurrentSession()
                .createCriteria(UserRoles.class)
                .add(Restrictions.eq("iduser", userid)).list();
    }
    
}
