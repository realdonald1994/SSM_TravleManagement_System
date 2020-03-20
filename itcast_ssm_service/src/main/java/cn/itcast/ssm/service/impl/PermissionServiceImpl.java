package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.PermissionDao;
import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * application layer: implementation
 * permission service
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    /**
     * search all authorities
     * @return
     * @throws Exception
     */
    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    /**
     * add authority
     * @param permission
     */
    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }
}
