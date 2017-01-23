/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uits.school.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import uits.school.domain.Groups;
import uits.school.domain.GroupsDao;

/**
 *
 * @author by ANNA ZHURAVLYOVA
 */
@Component
public class GroupsServiceImpl implements GroupsService{
    
    @Autowired
    private GroupsDao groupsDao;
    
    @Override
    public Groups byId(Integer id) {
        return groupsDao.byId(id);
    }

    @Override
    @Transactional
    public Groups byGroupsname(String name) {
        Groups groups = groupsDao.byGroupsname(name);
        return groups;
    }

    @Override
    public Integer save(Groups g) {
        return (Integer) groupsDao.save(g);
    }

    @Override
    public void update(Groups g) {
         groupsDao.save(g);
    }

    @Override
    public void delete(Groups g) {
        groupsDao.remove(g);
    }

    @Override
    public List<Groups> list() {
        List<Groups> groups = groupsDao.list();
        return groups;
    
    }
}
