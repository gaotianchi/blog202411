package com.gaotianchi.auth.controller;


import com.gaotianchi.auth.dto.CreateClientDto;
import com.gaotianchi.auth.entity.Client;
import com.gaotianchi.auth.enums.Code;
import com.gaotianchi.auth.service.ClientService;
import com.gaotianchi.auth.vo.ClientVO;
import com.gaotianchi.auth.vo.VO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.gaotianchi.auth.utils.MapTool.writeMap;

/**
 * @author gaotianchi
 * @since 2024/11/26 12:51
 **/
@RestController
@RequestMapping("client")
@Slf4j
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    public static Client fromDtoToClient(CreateClientDto createClientDto) {
        List<String> clientAuthenticationMethods = new ArrayList<>(createClientDto.getClientAuthenticationMethods().size());
        clientAuthenticationMethods.addAll(createClientDto.getClientAuthenticationMethods());

        List<String> authorizationGrantTypes = new ArrayList<>(createClientDto.getAuthorizationGrantTypes().size());
        authorizationGrantTypes.addAll(createClientDto.getAuthorizationGrantTypes());

        return Client.builder()
                .clientId(createClientDto.getClientId())
                .clientSecret(createClientDto.getClientSecret())
                .clientName(createClientDto.getClientName())
                .clientIdIssuedAt(Date.from(Objects.requireNonNull(createClientDto.getClientIdIssuedAt()).toInstant()))
                .clientAuthenticationMethods(StringUtils.collectionToCommaDelimitedString(clientAuthenticationMethods))
                .authorizationGrantTypes(StringUtils.collectionToCommaDelimitedString(authorizationGrantTypes))
                .redirectUris(StringUtils.collectionToCommaDelimitedString(createClientDto.getRedirectUris()))
                .scopes(StringUtils.collectionToCommaDelimitedString(createClientDto.getScopes()))
                .clientSettings(writeMap(createClientDto.getClientSettings()))
                .tokenSettings(writeMap(createClientDto.getTokenSettings()))
                .postLogoutRedirectUris(StringUtils.collectionToCommaDelimitedString(createClientDto.getPostLogoutRedirectUris()))
                .build();
    }

    @PostMapping("create")
    public VO<Void> create(@Valid @RequestBody CreateClientDto createClientDto) {
        log.info(createClientDto.toString());

        Client client = fromDtoToClient(createClientDto);
        clientService.insert(client);
        return VO.response(Code.SUCCESS, null);
    }

    @GetMapping("get")
    public VO<ClientVO> getByClientId(@RequestParam String clientId) {
        Client client = clientService.selectByClientId(clientId);

        ClientVO clientVO = ClientVO.builder()
                .id(client.getId())
                .clientName(client.getClientName())
                .clientIdIssuedAt(client.getClientIdIssuedAt())
                .clientAuthenticationMethods(client.getClientAuthenticationMethods())
                .tokenSettings(client.getTokenSettings())
                .scopes(client.getScopes())
                .redirectUris(client.getRedirectUris())
                .postLogoutRedirectUris(client.getPostLogoutRedirectUris())
                .clientSettings(client.getClientSettings())
                .authorizationGrantTypes(client.getAuthorizationGrantTypes())
                .build();
        return VO.response(Code.SUCCESS, clientVO);
    }
}
