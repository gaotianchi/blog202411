package com.gaotianchi.auth.service.impl;

import com.gaotianchi.auth.entity.User;
import com.gaotianchi.auth.dao.UserDao;
import com.gaotianchi.auth.service.UserService;
import org.springframework.stereotype.Service;
import com.gaotianchi.auth.enums.Code;
import com.gaotianchi.auth.exception.SQLException;


/**
 * 用户表(User)表服务实现类
 *
 * @author gaotianchi
 * @since 2024-11-28 20:45:39
 */
@Service("userService" )
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void insert(User user) {
        if (userDao.insert(user) != 1) {
            throw new SQLException(Code.SQL_INSERT_ERROR);
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (userDao.deleteById(id) != 1) {
            throw new SQLException(Code.SQL_DELETE_ERROR);
        }
    }

    @Override
    public void update(User user) {
        if (userDao.update(user) != 1) {
            throw new SQLException(Code.SQL_UPDATE_ERROR);
        }
    }

    @Override
    public User findById(Integer id) {
        return userDao.selectById(id);
    }
}
