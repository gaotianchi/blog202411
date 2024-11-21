package com.gaotianchi.resourceservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("init-user")
@Setter
@Getter
public class InitUserConfig {
    private String username;
    private String password;
    private String penName;
}
