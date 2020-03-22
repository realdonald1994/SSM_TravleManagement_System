package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.UserInfo;
import cn.itcast.ssm.service.UserService;
import cn.itcast.utils.BCryptPasswordEncoderUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * spring-security implementation
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * spring security->authority user
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo =null;
        try {
           userInfo =  userDao.findByUserName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //userDetails
//        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus() ==0?false:true,true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }

    // return ->list for role
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for(Role role:roles){
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

    /**
     * search all users
     * @return
     * @throws Exception
     */
    @Override
    public List<UserInfo> findAll(Integer page,Integer size) throws Exception {
        PageHelper.startPage(page,size);
        return userDao.findAll();
    }

    /**
     * save user
     * @param userInfo
     * @throws Exception
     */
    @Override
    public void save(UserInfo userInfo) throws Exception {
        //password Encryption
        userInfo.setPassword(BCryptPasswordEncoderUtils.encodingPassword(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    /**
     * search user by id
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public UserInfo findById(Integer userId) throws Exception {
        return userDao.findById(userId);
    }

    /**
     * search available roles by uerid
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public List<Role> findOtherRoles(Integer userId) throws Exception {
        return userDao.findOtherRoles(userId);
    }

    /**
     * add role to user
     * @param userId
     * @param roleIds
     * @throws Exception
     */
    @Override
    public void addRoleToUser(Integer userId, Integer[] roleIds) throws Exception {
        for(int roleId:roleIds){
            userDao.addRoleToUser(userId,roleId);
        }
    }

    /**
     * delete user
     * @param userId
     * @throws Exception
     */
    @Override
    public void delete(Integer userId) throws Exception {
        userDao.delete(userId);
    }

    /**
     * update user
     * @param userInfo
     * @throws Exception
     */
    @Override
    public void update(UserInfo userInfo) throws Exception {
        userInfo.setPassword(BCryptPasswordEncoderUtils.encodingPassword(userInfo.getPassword()));
        userDao.update(userInfo);
    }

    /**
     * batch delete users
     * @param ids
     * @throws Exception
     */
    @Override
    public void batchDelete(List<Integer> ids) throws Exception {
        for(Integer id:ids){
            userDao.delete(id);
        }
    }
}
