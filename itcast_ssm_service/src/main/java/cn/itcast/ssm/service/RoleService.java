package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.Role;

import java.util.List;

/**
 * application layer interface
 * role
 */
public interface RoleService {
    List<Role> findAll() throws Exception;


    void save(Role role) throws Exception;

    Role findById(Integer roleId) throws Exception;

    List<Permission> findOtherPermissions(Integer roleId) throws Exception;

    void addPermissionToRole(Integer roleId, Integer[] permissionIds)throws Exception;
}
