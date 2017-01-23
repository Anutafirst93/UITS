package uits.school.service;

import uits.school.domain.UserRoles;
import java.util.List;

public interface UserRolesService extends BaseService<UserRoles, Integer> {
    List<UserRoles> byUserId(Integer userid);
}
