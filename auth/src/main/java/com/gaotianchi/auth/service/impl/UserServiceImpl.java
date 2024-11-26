package com.gaotianchi.auth.service.impl;

import com.gaotianchi.auth.dao.RolePermissionDao;
import com.gaotianchi.auth.dao.UserDao;
import com.gaotianchi.auth.entity.User;
import com.gaotianchi.auth.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 用户表(User)表服务实现类
 *
 * @author gaotianchi
 * @since 2024-11-23 19:41:37
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final RolePermissionDao rolePermissionDao;

    public UserServiceImpl(UserDao userDao, RolePermissionDao rolePermissionDao) {
        this.userDao = userDao;
        this.rolePermissionDao = rolePermissionDao;
    }

    /**
     * 根据用户名加载用户账户详情
     *
     * @param username username
     * @return org.springframework.security.core.userdetails.UserDetails
     * @author gaotianchi
     * @since 2024/11/24 12:56
     **/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = queryByUsername(username);
        if (user == null) {
            System.out.println("user not found");
            throw new UsernameNotFoundException(username);
        }

        // 获取用户的角色以及权限，例子：["ROLE_ADMIN", ANY]
        List<String> authorities = rolePermissionDao.queryUserPermissionNameAndRoleNameWithRolePrefixByUsername(username);

        return UserDetailsImpl.builder().user(user).authorities(authorities.stream().map(SimpleGrantedAuthority::new).toList()).build();
    }

    /**
     * 通过 username 查询单条数据
     *
     * @param username username
     * @return User 实例对象
     */
    @Override
    public User queryByUsername(String username) {
        return userDao.queryByUsername(username);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return User 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return userDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param user        筛选条件
     * @param pageRequest 分页对象
     * @return Page<User> 查询结果
     */
    @Override
    public Page<User> queryByPage(User user, PageRequest pageRequest) {
        long total = userDao.count(user);
        return new PageImpl<>(userDao.queryByPage(user, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return User 实例对象
     */
    @Override
    public User insert(User user) {
        userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return User 实例对象
     */
    @Override
    public User update(User user) {
        userDao.update(user);
        return queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return boolean 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return userDao.deleteById(id) > 0;
    }
}
