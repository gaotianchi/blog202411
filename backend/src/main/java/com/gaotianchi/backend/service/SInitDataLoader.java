package com.gaotianchi.backend.service;

import com.gaotianchi.backend.config.InitUserConfig;
import com.gaotianchi.backend.presistence.entity.EUser;
import com.gaotianchi.backend.presistence.repositity.RUser;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class SInitDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private final RUser rUser;
    private final InitUserConfig initUserConfig;
    private final PasswordEncoder passwordEncoder;

    public SInitDataLoader(RUser rUser, InitUserConfig initUserConfig, PasswordEncoder passwordEncoder) {
        this.rUser = rUser;
        this.initUserConfig = initUserConfig;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initUserData();
    }

    private void initUserData() {
        EUser eUser = rUser.findByUsername(initUserConfig.getUsername());
        if (eUser == null) {
            eUser = new EUser();
            eUser.setPenName(initUserConfig.getPenName());
            eUser.setUsername(initUserConfig.getUsername());
            eUser.setPassword(passwordEncoder.encode(initUserConfig.getPassword()));
            eUser.setRegistrationDatetime(OffsetDateTime.now());
            rUser.save(eUser);
        }
    }
}
