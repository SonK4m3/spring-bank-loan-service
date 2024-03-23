package com.example.loanmanagement.service;

import com.example.loanmanagement.entity.LoanApplication;
import com.example.loanmanagement.entity.User;
import com.example.loanmanagement.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LoanApplicationService {
    @Autowired
    private LoanRepository loanRepository;

    public LoanApplication applyForLoan(LoanApplication loanApplication) {
        loanApplication.setReferenceNumber(generateReferenceNumber());
        return loanRepository.save(loanApplication);
    }

    private String generateReferenceNumber() {
        // Implement logic to generate a unique reference number
        return "REF123456"; // Example placeholder
    }
}
