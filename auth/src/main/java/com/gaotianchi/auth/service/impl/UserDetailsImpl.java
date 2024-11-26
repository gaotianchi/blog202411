package com.gaotianchi.auth.service.impl;

import com.gaotianchi.auth.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @author gaotianchi
 * @since 2024/11/24 19:47
 **/
@Setter
@Getter
@Builder
public class UserDetailsImpl implements UserDetails {

    private User user;
    private List<SimpleGrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getIsLocked() != 1;
    }

    @Override
    public boolean isEnabled() {
        return user.getIsEnabled() != 1;
    }
}
