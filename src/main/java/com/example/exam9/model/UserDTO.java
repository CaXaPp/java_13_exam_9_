package com.example.exam9.model;

import com.example.exam9.entity.Role;
import com.example.exam9.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private String login;
    private String email;
    private boolean enabled;
    private Role role;

    public static UserDTO of(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .login(user.getLogin())
                .email(user.getEmail())
                .enabled(user.isEnabled())
                .role(user.getRole())
                .build();
    }
}
