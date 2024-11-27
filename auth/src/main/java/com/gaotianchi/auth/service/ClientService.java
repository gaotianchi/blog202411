package com.gaotianchi.auth.service;

import com.gaotianchi.auth.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;

/**
 * 客户端表(Client)表服务接口
 *
 * @author gaotianchi
 * @since 2024-11-24 20:35:24
 */
public interface ClientService extends RegisteredClientRepository {

    void insert(Client client);

    void deleteById(Integer id);

    void update(Client client);

    Client selectById(Integer id);

    Client selectByClientId(String clientId);
}
