package com.fabric.ilearn.authentication;

import com.fabric.ilearn.dto.adm.principle.UserPrincipleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {
    @Autowired
    UserPrincipleDTO userPrinciple;

    public CustomUserDetails(UserPrincipleDTO userPrinciple){
        this.userPrinciple = userPrinciple;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userPrinciple.getUserRolesPrinciple().stream().map(role -> new SimpleGrantedAuthority(role.getRolePrinciple().getRoleName())).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return userPrinciple.getPassword();
    }

    @Override
    public String getUsername() {
        return userPrinciple.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
