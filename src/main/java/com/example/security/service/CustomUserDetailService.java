package com.example.security.service;

import com.example.security.dto.CustomUserDetails;
import com.example.security.entity.UserEntity;
import com.example.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        // 먼저 데이터베이스에서 사용자 조회
       UserEntity userDate = userRepository.findByUserName(username);

       if (userDate != null){
           return new CustomUserDetails(userDate);
       }


       throw new UsernameNotFoundException("User not found with username: " + username);
    }

}
