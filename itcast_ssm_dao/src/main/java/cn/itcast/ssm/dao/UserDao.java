package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    /**
     * find user by username
     * @param username
     * @return
     * @throws Exception
     */
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "cn.itcast.ssm.dao.RoleDao.findRoleByUserId"))
    })
    UserInfo findByUserName(String username) throws Exception;

    /**
     * search all users
     * @return
     */
    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;

    /**
     * save user
     * @param userInfo
     * @throws Exception
     */
    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;


    @Select("select * from users where id=#{userId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "cn.itcast.ssm.dao.RoleDao.findRoleByUserId")),
    })
    UserInfo findById(Integer userId) throws Exception;


    /**
     * saerch available role by useId
     * @param userId
     * @return
     */
    @Select("select * from role where id not in (select roleId from users_role where userId=#{userId})")
    List<Role> findOtherRoles(Integer userId) throws Exception;

    /**
     * add role to user
     * @param userId
     * @param roleId
     * @throws Exception
     */
    @Insert("insert into users_role (userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") Integer userId, @Param("roleId") Integer roleId) throws Exception;

    /**
     * delete user
     * @param userId
     * @throws Exception
     */
    @Delete("delete from users where id=#{userId}")
    void delete(Integer userId) throws Exception;

    /**
     * update User
     * @param userInfo
     */
    @Update("update users set email=#{email},username=#{username},password=#{password},phoneNum=#{phoneNum},status=#{status} where id=#{id}")
    void update(UserInfo userInfo) throws Exception;
}
