package com.tea.fambase.security;

import com.tea.fambase.domain.User;
import com.tea.fambase.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserRepoUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserRepoUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        System.out.println("UserRepoUserDetailsService.loadUserByUsername: user = " + user);
        if (user != null) return user;
        throw new UsernameNotFoundException("User " + s + " not found");
    }
}