package com.example.demosecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demosecurity.repos.UserRepo;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UserRepo userRepo;

    // public UserService(UserRepo userRepo){
    //     this.userRepo = userRepo;
    // }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }
    
}
