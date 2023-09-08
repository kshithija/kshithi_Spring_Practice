package com.app.kshithi.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.kshithi.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUserEmail(String userEmail);
}
