package com.gaotianchi.auth.service;

import com.gaotianchi.auth.entity.User;

/**
 * 用户表(User)表服务接口
 *
 * @author gaotianchi
 * @since 2024-11-28 20:19:44
 */
public interface UserService {

    void insert(User user);

    void deleteById(Integer id);

    void update(User user);

    User findById(Integer id);
}