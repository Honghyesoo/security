package com.example.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.Iterator;

@Controller
public class MainController {
    @GetMapping("/")
    public String mainP(Model model){
        //세션 현재 아이디 사용자
        String id = SecurityContextHolder.getContext().getAuthentication().getName();

        //세션 현재 사용자 role
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Collection<? extends GrantedAuthority> grantedAuthorities =
        authentication.getAuthorities();
        Iterator<? extends  GrantedAuthority> iterator = grantedAuthorities.iterator();
        GrantedAuthority authority = iterator.next();
        String role = authority.getAuthority();

        model.addAttribute("id",id);
        model.addAttribute("role",role);
        return "main";
    }
}
