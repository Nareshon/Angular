package com.cognizant.authentication.security;



import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.authentication.exception.UserAlreadyExistsException;
import com.cognizant.authentication.model.Role;
import com.cognizant.authentication.model.UserDb;
import com.cognizant.authentication.repository.RoleRepository;
import com.cognizant.authentication.repository.UserRepository;


@Service
public class AppUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppUserDetailsService.class);

	
	
	AppUser appUser;
	UserDb user;
	public AppUserDetailsService(UserRepository repository) {
		
		this.userRepository=repository;
		// TODO Auto-generated constructor stub
	}
	
	public AppUserDetailsService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppUserDetailsService(UserRepository userRepository, RoleRepository roleRepository) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		
		user = userRepository.findByUsername(userName);
		if(user == null)
			throw new UsernameNotFoundException("username not found");
		else
			appUser=new AppUser(user);
		return appUser;
	}
	
	
	
	 public PasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
	 }
	
	
	
	public void SignUp(UserDb user) throws UserAlreadyExistsException {
			
		
			UserDb userDb = userRepository.findByUsername(user.getUsername());
			if(userDb!=null) {
				throw new UserAlreadyExistsException();
			}
		
			else {
				LOGGER.debug("my passs"+user.getPassword());
				LOGGER.debug("user is   "+user);
			user.setPassword( passwordEncoder().encode(user.getPassword()));
			Role role=roleRepository.findById(2);
			Set <Role>roleList = new HashSet<Role>();
			roleList.add(role);
			user.setRoleList(roleList);
			userRepository.save(user);
			}

		
	}
	
	
	
	
	

}
