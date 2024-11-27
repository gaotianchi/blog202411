package com.gaotianchi.auth.dao;

import com.gaotianchi.auth.entity.Client;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 客户端表(Client)表数据库访问层
 *
 * @author gaotianchi
 * @since 2024-11-25 13:13:05
 */
@Mapper
public interface ClientDao {

    int insert(Client client);

    int deleteById(Integer id);

    int update(Client client);

    Client selectById(Integer id);

    Client selectByClientId(String clientId);
}

