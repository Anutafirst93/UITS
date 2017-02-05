package uits.school.domain;

import java.util.List;


public interface UserDao extends BaseDao<User, Integer>{
    User byUsername(String name);
    List<User> ListStudentsByGroupId(Integer id);
}
