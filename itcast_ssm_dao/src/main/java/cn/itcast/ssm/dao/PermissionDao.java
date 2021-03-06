package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * data layer permissionDao
 */
@Repository
public interface PermissionDao {

    /**
     * search authorities by role id
     * @param roleId
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findPermissionByRoleId(int roleId) throws Exception;

    /**
     * search all permissions
     * @return
     * @throws Exception
     */
    @Select("select * from permission")
    List<Permission> findAll() throws Exception;


    /**
     * save a authority
     * @param permission
     */
    @Insert("insert into permission(permissionName,url) value(#{permissionName},#{url})")
    void save(Permission permission) throws Exception;
}
