package com.example.loanmanagement.controller;

import com.example.loanmanagement.entity.LoanApplication;
import com.example.loanmanagement.repository.MemberRepository;
import com.example.loanmanagement.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/loan")
public class LoanController {
    @Autowired
    private LoanApplicationService loanApplicationService;

    @Autowired
    private MemberRepository memberRepository;

    @PostMapping("/apply")
    public ResponseEntity<LoanApplication> applyForLoan(@RequestBody LoanApplication loanApplication) {
        LoanApplication appliedLoan = loanApplicationService.applyForLoan(loanApplication);
        return ResponseEntity.status(HttpStatus.CREATED).body(appliedLoan);
    }
}
