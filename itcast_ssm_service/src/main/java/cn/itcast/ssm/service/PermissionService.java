package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Permission;

import java.util.List;

/**
 * application layer interface
 * permission(authority)
 */
public interface PermissionService {

    List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;
}
