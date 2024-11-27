package com.gaotianchi.auth.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * (Client)实体类
 *
 * @author gaotianchi
 * @since 2024-11-27 21:01:31
 */
@Data
@Builder
public class Client implements Serializable {

    @Serial
    private static final long serialVersionUID = 269572350292701620L;

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

