package uits.school.domain;


public interface UserDao extends BaseDao<User, Integer>{
    User byUsername(String name);
}
