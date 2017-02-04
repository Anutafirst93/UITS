package uits.school.domain;

import java.util.List;

public interface UserRolesDao extends BaseDao<UserRoles, Integer>{
    List<UserRoles> byUserId(Integer userid);
}
