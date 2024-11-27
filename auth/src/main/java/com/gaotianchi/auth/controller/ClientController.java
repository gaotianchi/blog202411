package com.gaotianchi.auth.controller;


import com.gaotianchi.auth.dto.CreateClientDto;
import com.gaotianchi.auth.entity.Client;
import com.gaotianchi.auth.enums.Code;
import com.gaotianchi.auth.service.ClientService;
import com.gaotianchi.auth.vo.ClientVO;
import com.gaotianchi.auth.vo.VO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.gaotianchi.auth.utils.MapTool.parseMap;
import static com.gaotianchi.auth.utils.MapTool.writeMap;

/**
 * @author gaotianchi
 * @since 2024/11/26 12:51
 **/
@RestController
@RequestMapping("client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    private Client fromDtoToClient(CreateClientDto createClientDto) {
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

    private ClientVO fromClientToClientVO(Client client) {
        return ClientVO.builder()
                .id(client.getId())
                .clientName(client.getClientName())
                .clientIdIssuedAt(client.getClientIdIssuedAt())
                .clientAuthenticationMethods(StringUtils.commaDelimitedListToSet(client.getClientAuthenticationMethods()))
                .tokenSettings(parseMap(client.getTokenSettings()))
                .scopes(StringUtils.commaDelimitedListToSet(client.getScopes()))
                .redirectUris(StringUtils.commaDelimitedListToSet(client.getRedirectUris()))
                .postLogoutRedirectUris(client.getPostLogoutRedirectUris())
                .clientSettings(parseMap(client.getClientSettings()))
                .authorizationGrantTypes(StringUtils.commaDelimitedListToSet(client.getAuthorizationGrantTypes()))
                .build();
    }

    @PostMapping("new")
    public VO<String> createClient(@Valid @RequestBody CreateClientDto createClientDto) {
        Client client = fromDtoToClient(createClientDto);
        clientService.insert(client);
        return VO.response(Code.SUCCESS, "/client/info/" + client.getClientId());
    }

    @GetMapping("info")
    public VO<ClientVO> getInfoById(@RequestParam @NotBlank(message = "客户端ID不能为空") Integer id) {
        Client client = clientService.selectById(id);

        ClientVO clientVO = fromClientToClientVO(client);
        return VO.response(Code.SUCCESS, clientVO);
    }
}
