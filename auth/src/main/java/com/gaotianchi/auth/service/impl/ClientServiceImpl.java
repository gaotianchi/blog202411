package com.gaotianchi.auth.service.impl;

import com.gaotianchi.auth.dao.ClientDao;
import com.gaotianchi.auth.entity.Client;
import com.gaotianchi.auth.enums.RestCode;
import com.gaotianchi.auth.exception.SqlException;
import com.gaotianchi.auth.service.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.*;

import static com.gaotianchi.auth.utils.MapTool.parseMap;


/**
 * 客户端表(Client)表服务实现类
 *
 * @author gaotianchi
 * @since 2024-11-24 20:35:24
 */
@Service("clientService")
public class ClientServiceImpl implements ClientService {

    private final ClientDao clientDao;

    public ClientServiceImpl(ClientDao clientDao) {
        Assert.notNull(clientDao, "clientRepository cannot be null");
        this.clientDao = clientDao;
    }

    private static AuthorizationGrantType resolveAuthorizationGrantType(String authorizationGrantType) {
        if (AuthorizationGrantType.AUTHORIZATION_CODE.getValue().equals(authorizationGrantType)) {
            return AuthorizationGrantType.AUTHORIZATION_CODE;
        } else if (AuthorizationGrantType.CLIENT_CREDENTIALS.getValue().equals(authorizationGrantType)) {
            return AuthorizationGrantType.CLIENT_CREDENTIALS;
        } else if (AuthorizationGrantType.REFRESH_TOKEN.getValue().equals(authorizationGrantType)) {
            return AuthorizationGrantType.REFRESH_TOKEN;
        }
        return new AuthorizationGrantType(authorizationGrantType);              // Custom authorization grant type
    }

    private static ClientAuthenticationMethod resolveClientAuthenticationMethod(String clientAuthenticationMethod) {
        if (ClientAuthenticationMethod.CLIENT_SECRET_BASIC.getValue().equals(clientAuthenticationMethod)) {
            return ClientAuthenticationMethod.CLIENT_SECRET_BASIC;
        } else if (ClientAuthenticationMethod.CLIENT_SECRET_POST.getValue().equals(clientAuthenticationMethod)) {
            return ClientAuthenticationMethod.CLIENT_SECRET_POST;
        } else if (ClientAuthenticationMethod.NONE.getValue().equals(clientAuthenticationMethod)) {
            return ClientAuthenticationMethod.NONE;
        }
        return new ClientAuthenticationMethod(clientAuthenticationMethod);      // Custom client authentication method
    }

    public static RegisteredClient fromClientToRegisteredClient(Client client) {

        Set<String> clientAuthenticationMethods = StringUtils.commaDelimitedListToSet(
                client.getClientAuthenticationMethods());
        Set<String> authorizationGrantTypes = StringUtils.commaDelimitedListToSet(
                client.getAuthorizationGrantTypes());
        Set<String> redirectUris = StringUtils.commaDelimitedListToSet(
                client.getRedirectUris());
        Set<String> clientScopes = StringUtils.commaDelimitedListToSet(
                client.getScopes());
        Set<String> postLogoutRedirectUris = StringUtils.commaDelimitedListToSet(
                client.getPostLogoutRedirectUris());

        RegisteredClient.Builder builder = RegisteredClient.withId(client.getClientId())
                .id(client.getId().toString())
                .clientId(client.getClientId())
                .clientSecret(client.getClientSecret())
                .clientName(client.getClientName())
                .clientIdIssuedAt(client.getClientIdIssuedAt().toInstant())
                .clientAuthenticationMethods(authenticationMethods ->
                        clientAuthenticationMethods.forEach(authenticationMethod ->
                                authenticationMethods.add(resolveClientAuthenticationMethod(authenticationMethod))))
                .authorizationGrantTypes((grantTypes) ->
                        authorizationGrantTypes.forEach(grantType ->
                                grantTypes.add(resolveAuthorizationGrantType(grantType))))
                .redirectUris((uris) -> uris.addAll(redirectUris))
                .scopes((scopes) -> scopes.addAll(clientScopes))
                .postLogoutRedirectUris((uris) -> uris.addAll(postLogoutRedirectUris));

        Map<String, Object> clientSettingsMap = parseMap(client.getClientSettings());
        builder.clientSettings(ClientSettings.withSettings(clientSettingsMap).build());

        Map<String, Object> tokenSettingsMap = parseMap(client.getTokenSettings());
        builder.tokenSettings(TokenSettings.withSettings(tokenSettingsMap).build());

        return builder.build();
    }

    @Override
    public void insert(Client client) {
        int row = clientDao.insert(client);
        if (row != 1) {
            throw new SqlException(RestCode.SQL_INSERT_ERROR);
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        return clientDao.deleteById(id) == 1;
    }

    @Override
    public boolean update(Client client) {
        return clientDao.update(client) > 0;
    }

    @Override
    public Client selectById(Integer id) {
        return clientDao.selectById(id);
    }

    @Override
    public Client selectByClientId(String clientId) {
        return clientDao.selectByClientId(clientId);
    }

    @Override
    public Page<Client> selectByPage(Client client, PageRequest pageRequest) {
        long total = clientDao.count(client);
        return new PageImpl<>(clientDao.selectByPage(client, pageRequest), pageRequest, total);
    }

    @Override
    public void save(RegisteredClient registeredClient) {
    }

    @Override
    public RegisteredClient findById(String id) {
        Client client = selectById(Integer.valueOf(id));
        return fromClientToRegisteredClient(client);
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        Client client = selectByClientId(clientId);
        return fromClientToRegisteredClient(client);
    }

}