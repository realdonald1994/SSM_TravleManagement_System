package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Permission;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * data layer permissionDao
 */
@Repository
public interface PermissionDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findPermissionByRoleId(int roleId) throws Exception;
}
