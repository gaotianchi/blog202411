package com.gaotianchi.auth.controller;


import com.gaotianchi.auth.dto.CreateClientDto;
import com.gaotianchi.auth.entity.Client;
import com.gaotianchi.auth.enums.Code;
import com.gaotianchi.auth.service.ClientService;
import com.gaotianchi.auth.vo.ClientVO;
import com.gaotianchi.auth.vo.VO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.gaotianchi.auth.utils.MapTool.parseMap;
import static com.gaotianchi.auth.utils.MapTool.writeMap;

/**
 * @author gaotianchi
 * @since 2024/11/26 12:51
 **/
@RestController
@RequestMapping("client" )
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
                .clientAuthenticationMethods(StringUtils.collectionToCommaDelimitedString(clientAuthenticationMethods))
                .authorizationGrantTypes(StringUtils.collectionToCommaDelimitedString(authorizationGrantTypes))
                .redirectUris(StringUtils.collectionToCommaDelimitedString(createClientDto.getRedirectUris()))
                .scopes(StringUtils.collectionToCommaDelimitedString(createClientDto.getScopes()))
                .postLogoutRedirectUris(StringUtils.collectionToCommaDelimitedString(createClientDto.getPostLogoutRedirectUris()))
                .build();
    }

    private ClientVO fromClientToClientVO(Client client) {
        return ClientVO.builder()
                .id(client.getId())
                .clientId(client.getClientId())
                .clientName(client.getClientName())
                .clientIdIssuedAt(client.getClientIdIssuedAt())
                .clientAuthenticationMethods(StringUtils.commaDelimitedListToSet(client.getClientAuthenticationMethods()))
                .scopes(StringUtils.commaDelimitedListToSet(client.getScopes()))
                .redirectUris(StringUtils.commaDelimitedListToSet(client.getRedirectUris()))
                .postLogoutRedirectUris(client.getPostLogoutRedirectUris())
                .clientSecretExpiresAt(client.getClientSecretExpiresAt())
                .authorizationGrantTypes(StringUtils.commaDelimitedListToSet(client.getAuthorizationGrantTypes()))
                .build();
    }

    @PostMapping("" )
    public VO<String> createClient(@Valid @RequestBody CreateClientDto createClientDto) {
        Client client = fromDtoToClient(createClientDto);
        clientService.insert(client);
        return VO.response(Code.SUCCESS, "/client/info/" + client.getId());
    }

    @DeleteMapping("{id}" )
    public VO<Void> deleteClientById(@PathVariable
                                     @NotNull(message = "id 不能为空" )
                                     @Min(value = 1, message = "id 必须大于等于 1" ) Integer id) {
        clientService.deleteById(id);
        return VO.response(Code.SUCCESS, null);
    }

    @GetMapping("info/{id}" )
    public VO<ClientVO> getInfoById(@PathVariable
                                    @NotNull(message = "id 不能为空" )
                                    @Min(value = 1, message = "id 必须大于等于 1" ) Integer id) {
        Client client = clientService.findById(id);

        ClientVO clientVO = fromClientToClientVO(client);
        return VO.response(Code.SUCCESS, clientVO);
    }
}
