package com.renevoi.security.springsecurityoauthserver.service;

import com.renevoi.security.springsecurityoauthserver.model.CustomUserDetails;
import com.renevoi.security.springsecurityoauthserver.model.Users;
import com.renevoi.security.springsecurityoauthserver.repository.UsersRepository;
import org.hibernate.service.UnknownServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Users> usersOptional = usersRepository.findByName(username);

        usersOptional // if the user is not there do this
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
                      // if it is present then do this
        return usersOptional
                .map(users -> new CustomUserDetails(users))
                .get();
    }
}
