/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uits.school.service;

import uits.school.domain.Groups;


/**
 *
 * @author by ANNA ZHURAVLYOVA
 */
public interface GroupsService extends BaseService<Groups, Integer>{
    Groups byGroupsname (String name);
    
}
