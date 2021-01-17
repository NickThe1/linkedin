package com.nick.software.link.linkedin.persistence.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, VIP, ADMIN;

    @Override
    public String getAuthority() {
        return null;
    }
}
