package uits.school.service;

import uits.school.domain.User;

/**
 *
 * @author user
 */
public interface UserService extends BaseService<User, Integer>{
    User byUsername(String name);
}
