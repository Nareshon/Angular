
package com.cognizant.truyum.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.model.UserDb;
import com.cognizant.truyum.security.AppUserDetailsService;


@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:4200")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    
	@Autowired
	AppUserDetailsService appUserDetailsService;
	
	
//	@Autowired
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager;
//    
//    public static List<UserDetails> userDetailsList = new ArrayList<>();
//    
//    
//    public UserController() {
//        super();
//        userDetailsList.add(
//                org.springframework.security.core.userdetails.User.withUsername("user")
//                    .password(passwordEncoder()
//                    .encode("pwd"))
//                    .roles("USER").build());
//            
//            userDetailsList.add(
//                    org.springframework.security.core.userdetails.User.withUsername("admin")
//                    .password(passwordEncoder()
//                    .encode("pwd"))
//                    .roles("ADMIN").build()); 
//            
//
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
    
    @PostMapping()
    public void signup(@RequestBody @Valid UserDb user) throws Exception {
    	
//    	LOGGER.info("sda"+user.getUserName()+"dsa"+user.getUserPassword());
//        boolean userDetails = inMemoryUserDetailsManager.userExists(user.getUserName());
//        LOGGER.info("boolean"+userDetails);
//        if(!userDetails) {
//        	
//           inMemoryUserDetailsManager.createUser(org.springframework.security.core.userdetails.User
//                    .withUsername(user.getUserName()).password(passwordEncoder().encode(user.getUserPassword()))
//                            .roles("USER").build());
//            userDetailsList.add(org.springframework.security.core.userdetails.User
//                    .withUsername(user.getUserName()).password(passwordEncoder().encode(user.getUserPassword()))
//                    .roles("USER").build());
//
//        }
//        LOGGER.info("userDetailsList :"+userDetailsList);
//    }

    	
    	
    	System.out.println(user);
    	appUserDetailsService.SignUp(user);
    	
    	
    	
}
}












