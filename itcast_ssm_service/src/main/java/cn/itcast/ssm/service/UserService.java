package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Spring security->userDetailsService
 */
public interface UserService extends UserDetailsService {

    List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(int userId) throws Exception;
}
