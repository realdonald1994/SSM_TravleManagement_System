package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * data layer roleDao
 */
@Repository
public interface RoleDao {
    /**
     * search role by user id
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("select * from Role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "cn.itcast.ssm.dao.PermissionDao.findPermissionByRoleId"))
    })
    List<Role> findRoleByUserId(int userId) throws Exception;

    /**
     * search All roles
     * @return
     * @throws Exception
     */
    @Select("select * from role")
    List<Role> findAll() throws Exception;

    /**
     * save role
     * @param role
     */
    @Insert("insert into role(roleName,roleDesc) value(#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;

    /**
     * search role by id
     * @param roleId
     * @return
     */
    @Select("select * from role where id=#{roleId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "cn.itcast.ssm.dao.PermissionDao.findPermissionByRoleId"))
    })
    Role findById(Integer roleId) throws Exception;

    /**
     * search authorities by role id
     * @param roleId
     * @return
     */
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermissions(Integer roleId) throws Exception;

    /**
     * add authority to role
     * @param roleId
     * @param permissionId
     */
    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") Integer roleId, @Param("permissionId") Integer permissionId) throws Exception;
}
