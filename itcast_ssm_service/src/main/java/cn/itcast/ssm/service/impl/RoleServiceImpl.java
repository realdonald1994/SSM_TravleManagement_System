package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.RoleDao;
import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * application layer: implementation
 * role service
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    /**
     * search all roles
     * @return
     * @throws Exception
     */
    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    /**
     * save role
     * @param role
     * @throws Exception
     */
    @Override
    public void save(Role role) throws Exception{
        roleDao.save(role);
    }

    /**
     * search role by id
     * @param roleId
     * @return
     * @throws Exception
     */
    @Override
    public Role findById(Integer roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    /**
     * search authorities by role id
     * @param roleId
     * @return
     */
    @Override
    public List<Permission> findOtherPermissions(Integer roleId) throws Exception{
        return roleDao.findOtherPermissions(roleId);
    }

    /**
     * add authority to role
     * @param roleId
     * @param permissionIds
     * @throws Exception
     */
    @Override
    public void addPermissionToRole(Integer roleId, Integer[] permissionIds) throws Exception {
        for(Integer permissionId:permissionIds){
            roleDao.addPermissionToRole(roleId,permissionId);
        }

    }
}
