package com.gaotianchi.backend.service;

import com.gaotianchi.backend.Response.info.UserInfo;
import com.gaotianchi.backend.presistence.entity.EUser;
import com.gaotianchi.backend.presistence.repositity.RUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SUser implements UserDetailsService, SIUser {
    private final RUser rUser;
    private final PasswordEncoder passwordEncoder;

    public SUser(RUser rUser, PasswordEncoder passwordEncoder) {
        this.rUser = rUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return rUser.findByUsername(username);
    }

    @Override
    public UserInfo newUser() {
        return null;
    }

    @Override
    public void deleteUser() {

    }

    @Override
    public UserInfo getInfo() {
        EUser eUser = rUser.findFirstBy();
        return new UserInfo(eUser);
    }

    @Override
    public void updatePassword(String newPassword) {
        EUser eUser = rUser.findFirstBy();
        eUser.setPassword(passwordEncoder.encode(newPassword));
        rUser.save(eUser);
    }

    @Override
    public void updatePenName(String newPenName) {
        EUser eUser = rUser.findFirstBy();
        eUser.setPassword(newPenName);
        rUser.save(eUser);
    }
}
