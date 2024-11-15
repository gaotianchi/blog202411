package com.gaotianchi.backend.presistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Setter
@Getter
public class EUser implements UserDetails {
    @Id
    @GeneratedValue
    private Short id;
    private String username;
    private String password;
    private String penName;
    private OffsetDateTime registrationDatetime;

    @OneToMany(mappedBy = "author")
    private List<EArticle> articleList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
}
