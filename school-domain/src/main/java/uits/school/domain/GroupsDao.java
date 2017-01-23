/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uits.school.domain;

/**
 *
 * @author by ANNA ZHURAVLYOVA
 */
public interface GroupsDao extends BaseDao<Groups, Integer>{

    public Groups byGroupsname(String name);
    
}
