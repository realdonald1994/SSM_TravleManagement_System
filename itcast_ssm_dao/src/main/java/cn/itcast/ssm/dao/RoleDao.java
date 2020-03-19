package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * data layer roleDao
 */
public interface RoleDao {
    /**
     * search role by user id
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("select * from Role where id in (select roleId from users_role where userId=#{userId})")
    List<Role> findRoleByUserId(int userId) throws Exception;

}
