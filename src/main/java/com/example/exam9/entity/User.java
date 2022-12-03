package com.example.exam9.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 4, max = 25, message = "Length must be > 4 and < 25")
    @Column(length = 25)
    private String name;

    @NotBlank
    @Size(min = 4, max = 25, message = "Length must be > 4 and < 25")
    @Column(length = 25)
    private String login;

    @Column(length = 128)
    private String password;

    @NotBlank
    @Email
    @Size(min = 4, max = 25, message = "Length must be > 4 and < 25")
    @Column(length = 25)
    private String email;

    @Column
    private boolean enabled = true;

    @Enumerated(value = EnumType.STRING)
    @Column
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
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
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
