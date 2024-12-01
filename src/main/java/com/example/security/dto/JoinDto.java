package com.example.security.dto;

import lombok.*;
import org.checkerframework.checker.units.qual.N;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JoinDto {
    private String userName;
    private String password;
}
