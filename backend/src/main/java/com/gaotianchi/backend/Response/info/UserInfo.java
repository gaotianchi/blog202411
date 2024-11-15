package com.gaotianchi.backend.Response.info;

import com.gaotianchi.backend.presistence.entity.EUser;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Setter
@Getter
public class UserInfo {
    private Short id;
    private String username;
    private String penName;
    private OffsetDateTime registrationDatetime;

    private String articleListUrl;

    public UserInfo(EUser eUser) {
        id = eUser.getId();
        username = eUser.getUsername();
        penName = eUser.getPenName();
        registrationDatetime = eUser.getRegistrationDatetime();

        articleListUrl = "http://localhost:8080/articles/info-list/0";
    }
}
