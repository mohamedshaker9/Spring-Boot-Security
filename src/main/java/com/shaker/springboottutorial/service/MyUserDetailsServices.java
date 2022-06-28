package com.shaker.springboottutorial.service;

import com.shaker.springboottutorial.entity.User;
import com.shaker.springboottutorial.models.MyUserDetails;
import com.shaker.springboottutorial.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsServices implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUserName(username);

        user.orElseThrow(() -> new UsernameNotFoundException(username + " Not Fount"));

        return user.map(MyUserDetails::new).get();
    }
}
