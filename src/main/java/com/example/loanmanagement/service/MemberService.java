package com.example.loanmanagement.service;

import com.example.loanmanagement.entity.User;
import com.example.loanmanagement.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public User createUser(User user) {
        return memberRepository.save(user);
    }

    public Optional<User> existsByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

    public Optional<User> existsByEmail(String email) {
        return memberRepository.findByEmail(email);
    }
}
