package com.example.NaoSeiONome.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.web.embedded.netty.NettyWebServer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String login;
    private String image;
    private String password;
    private UserRole role;
    private Boolean isLocked;

    public User(String name, String login, String image, String password, UserRole role) {
        this.name = name;
        this.login = login;
        this.image = image;
        this.password = password;
        this.role = role;
        this.isLocked = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_EMPRESA"), new SimpleGrantedAuthority("ROLE_CLIENTE"));
        } else if (this.role == UserRole.EMPRESA) {
            return List.of(new SimpleGrantedAuthority("ROLE_EMPRESA"), new SimpleGrantedAuthority("ROLE_CLIENTE"));
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_CLIENTE"));
        }
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isLocked;
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
