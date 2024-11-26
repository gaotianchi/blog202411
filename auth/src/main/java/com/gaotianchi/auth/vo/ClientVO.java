package com.gaotianchi.auth.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author gaotianchi
 * @since 2024/11/26 21:16
 **/
@Data
@Builder
public class ClientVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

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
    private Date clientSecretIssuedAt;
    private String postLogoutRedirectUris;
}
