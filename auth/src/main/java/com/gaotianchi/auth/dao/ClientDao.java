package com.gaotianchi.auth.dao;

import com.gaotianchi.auth.entity.Client;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Client)表数据库访问层
 *
 * @author gaotianchi
 * @since 2024-11-27 21:32:50
 */
@Mapper
public interface ClientDao {

    int insert(Client client);

    int deleteById(Integer id);

    int update(Client client);

    Client queryById(Integer id);
}

