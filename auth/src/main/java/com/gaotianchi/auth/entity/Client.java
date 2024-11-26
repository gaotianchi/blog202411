package com.gaotianchi.auth.entity;

import java.util.Date;

import lombok.Data;
import lombok.Builder;

import java.io.Serializable;
import java.io.Serial;

/**
 * 客户端表(Client)实体类
 *
 * @author gaotianchi
 * @since 2024-11-25 13:13:05
 */
@Data
@Builder
public class Client implements Serializable {

    @Serial
    private static final long serialVersionUID = -87995444269563809L;

    private Integer id;
    private String clientId;
    private Date clientIdIssuedAt;
    private String clientName;
    private String clientAuthenticationMethods;
    private String clientSettings;
    private String tokenSettings;
    private String authorizationGrantTypes;
    private String scopes;
    private String redirectUris;
    private String clientSecret;
    private Date clientSecretIssuedAt;
    private String postLogoutRedirectUris;
}

