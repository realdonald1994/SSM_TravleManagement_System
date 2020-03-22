package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Spring security->userDetailsService
 */
public interface UserService extends UserDetailsService {

    List<UserInfo> findAll(Integer page,Integer size) throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(int userId) throws Exception;

    List<Role> findOtherRoles(int userId) throws Exception;

    void addRoleToUser(int userId, int[] roleIds) throws Exception;

    void delete(Integer userId) throws Exception;

    void update(UserInfo userInfo) throws Exception;

    void batchDelete(List<Integer> ids) throws Exception;
}
