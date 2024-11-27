package com.gaotianchi.auth.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Set;

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
    private Set<String> clientAuthenticationMethods;
    private Map<String, Object> clientSettings;
    private Map<String, Object> tokenSettings;
    private Set<String> authorizationGrantTypes;
    private Set<String> scopes;
    private Set<String> redirectUris;
    private Date clientSecretIssuedAt;
    private String postLogoutRedirectUris;
}
