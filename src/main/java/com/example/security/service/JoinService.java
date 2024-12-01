package com.example.security.service;

import com.example.security.dto.JoinDto;
import com.example.security.entity.UserEntity;
import com.example.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void  joinProcess(JoinDto joinDto){
        //db에 이미 동일한 username을 가진 회원이 존재하는지?
        boolean isUser = userRepository.existsByUserName(joinDto.getUserName());
        if (isUser){
            return;
        }

        UserEntity user = UserEntity.builder()
                .userName(joinDto.getUserName())
                .password(bCryptPasswordEncoder.encode(joinDto.getPassword()))
                .role("ROLE_ADMIN")
                .build();


        userRepository.save(user);
    }
}
