package com.gaotianchi.auth.entity;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * (Client)实体类
 *
 * @author gaotianchi
 * @since 2024-11-27 18:31:00
 */
@Data
@Builder
public class Client implements Serializable {

    @Serial
    private static final long serialVersionUID = -79066551719035182L;

    private Integer id;
    private String clientId;
    private Date clientIdIssuedAt;
    private String clientSecret;
    private Date clientSecretExpiresAt;
    private String clientName;
    private String clientAuthenticationMethods;
    private String authorizationGrantTypes;
    private String redirectUris;
    private String postLogoutRedirectUris;
    private String scopes;
    private String clientSettings;
    private String tokenSettings;
}

