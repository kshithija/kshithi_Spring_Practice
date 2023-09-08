package com.app.kshithi.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.kshithi.User;
import com.app.kshithi.repo.UserRepository;
import com.app.kshithi.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository repo;
	
	public Integer saveUser(User user) {
		return repo.save(user).getUserId();
	}

	public Optional<User> getOneUser(Integer id) {
		return repo.findById(id);
	}

}
