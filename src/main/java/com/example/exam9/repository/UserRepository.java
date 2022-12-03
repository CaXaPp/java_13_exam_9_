package com.example.exam9.repository;

import com.example.exam9.entity.Role;
import com.example.exam9.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin (String login);

    List<User> findAllByRole(Role role);
}
