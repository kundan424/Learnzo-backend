package com.learnzo.student_management.service;

import com.learnzo.student_management.entity.AppUser;
import com.learnzo.student_management.repository.AppUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.info(">>> Attempting to load user by username: {}", username);

        // 1. find the user in database
        AppUser appUser = appUserRepository.findByUsername(username);

        // 2. If not found, you MUST throw this specific exception
        if (appUser == null) {
            logger.error("!!! User not found with username: {}", username);
            throw new RuntimeException("User not found: " + username);
        }


        logger.info(">>> User '{}' found in the database. Proceeding to create UserDetails.", username);


        // 3. convert user object into Spring Security UserDetails object and return it
        return org.springframework.security.core.userdetails.User.builder()
                .username(appUser.getUsername())
                .password(appUser.getPassword())
                .roles(appUser.getRoles())
                .build();
    }

}
