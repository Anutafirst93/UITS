/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uits.school.domain;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

/**
 *
 * @author by Anna Zhuravlyova
 */
@Component
public class GroupsDaoImpl extends AbstractDao<Groups, Integer> implements GroupsDao {

    @Override
    public Groups byGroupsname(String name) {
        return (Groups)getCurrentSession().createCriteria(Groups.class)
                .add(Restrictions.eq("name", name)).uniqueResult();
    }
    
}
