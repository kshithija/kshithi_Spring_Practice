package com.app.kshithi.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.kshithi.User;
import com.app.kshithi.repo.UserRepository;
import com.app.kshithi.service.IUserService;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService  {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public Integer saveUser(User user) {
		String encPwd = passwordEncoder.encode(user.getUserPwd());
		user.setUserPwd(encPwd);
		return repo.save(user).getUserId();
	}

	public Optional<User> getOneUser(Integer id) {
		return repo.findById(id);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> opt = repo.findByUserEmail(username);
		if(opt.isEmpty()) {
			throw new UsernameNotFoundException(username + " not exist");
		}
		User user =  opt.get();
		/*
		 * List<GrantedAuthority> authorities = new ArrayList<>(); for(String role :
		 * user.getUserRoles()) { authorities.add(new SimpleGrantedAuthority(role)); }
		 */
		
		//by using Java 8 Stream API
		
		  List<GrantedAuthority> authorities = user.getUserRoles() .stream()
		  .map(role-> new SimpleGrantedAuthority(role)) .collect(Collectors.toList());
		 
		
		return new org.springframework.security.core.userdetails.User(
				username, user.getUserPwd(), authorities);
	}

}
