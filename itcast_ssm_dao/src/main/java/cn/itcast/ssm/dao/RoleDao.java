package cn.itcast.ssm.dao;

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
}
