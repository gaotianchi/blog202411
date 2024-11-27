package com.gaotianchi.auth.dao;

import com.gaotianchi.auth.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表(User)表数据库访问层
 *
 * @author gaotianchi
 * @since 2024-11-27 21:32:50
 */
@Mapper
public interface UserDao {

    int insert(User user);

    int deleteById(Integer id);

    int update(User user);

    User queryById(Integer id);
}

