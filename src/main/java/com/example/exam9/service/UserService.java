package com.example.exam9.service;

import com.example.exam9.entity.Role;
import com.example.exam9.entity.User;
import com.example.exam9.model.AddUserDto;
import com.example.exam9.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public User createUser(AddUserDto dto, User principal) {
        User user = new User();
        user.setName(dto.getName());
        user.setLogin(dto.getLogin());
        user.setEnabled(true);
        user.setRole(dto.getRole());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setEmail(dto.getEmail());
        return repository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username).orElseThrow(IllegalArgumentException::new);
    }

    public List<User> findAllDevelopers(){
        return repository.findAllByRole(Role.DEVELOPER);
    }
}
