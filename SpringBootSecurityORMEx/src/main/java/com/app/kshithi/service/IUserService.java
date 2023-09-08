package com.app.kshithi.service;

import java.util.Optional;

import com.app.kshithi.User;

public interface IUserService {

	Integer saveUser(User user);
	Optional<User> getOneUser(Integer id);
}
