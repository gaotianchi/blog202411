package com.gaotianchi.auth.entity;

import java.util.Date;

import lombok.Data;
import lombok.Builder;

import java.io.Serializable;
import java.io.Serial;

/**
 * (Client)实体类
 *
 * @author gaotianchi
 * @since 2024-11-30 19:25:56
 */
@Data
@Builder
public class Client implements Serializable {

    @Serial
    private static final long serialVersionUID = -67741514635894671L;

    private Integer id;
    private String clientId;
    private Date clientIdIssuedAt;
    private String clientSecret;
    private Date clientSecretExpiresAt;
    private String clientName;
    private String authorizationGrantTypes;
    private String redirectUris;
    private String postLogoutRedirectUris;
    private String scopes;
    private String clientAuthenticationMethods;
    private Integer requireProofKey;
    private Integer requireAuthorizationConsent;
    private Integer accessTokenTimeLive;
    private Integer refreshTokenTimeToLive;
    private Integer reuseRefreshTokens;
}

