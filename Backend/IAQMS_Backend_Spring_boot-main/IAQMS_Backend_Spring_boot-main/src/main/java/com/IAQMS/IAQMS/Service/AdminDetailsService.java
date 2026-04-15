package com.IAQMS.IAQMS.Service;

import com.IAQMS.IAQMS.Model.AdminLoginData;
import com.IAQMS.IAQMS.Repository.AdminLoginRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AdminDetailsService implements UserDetailsService {

    private final AdminLoginRepository adminRepo;

    public AdminDetailsService(AdminLoginRepository adminRepo){
         this.adminRepo = adminRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        AdminLoginData admin = adminRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Admin not found"));

        return   org.springframework.security.core.userdetails.User
                .withUsername(admin.getUsername())
                .password(admin.getPassword())
                .roles(admin.getRole())
                .build();
    }
}
