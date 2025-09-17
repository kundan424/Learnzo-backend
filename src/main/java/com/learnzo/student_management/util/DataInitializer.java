package com.learnzo.student_management.util;

import com.learnzo.student_management.entity.AppUser;
import com.learnzo.student_management.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run (String... args) throws Exception {
        // Check if the admin user already exists
        if (appUserRepository.findByUsername("admin") == null) {
            // create a admin user
            AppUser adminUser = new AppUser();
            adminUser.setUsername("admin");

            // IMPORTANT: Encode the password before saving
            adminUser.setPassword(passwordEncoder.encode("admin123"));
            adminUser.setRoles("ADMIN");

            appUserRepository.save(adminUser);
            System.out.println("Admin user created successfully!");
        }
    }
}
