package com.gaotianchi.auth.service.impl;

import com.gaotianchi.auth.model.entity.User;
import com.gaotianchi.auth.dao.UserDao;
import com.gaotianchi.auth.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;


/**
 * 用户表(User)表服务实现类
 *
 * @author gaotianchi
 * @since 2024-11-23 17:48:23
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
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
