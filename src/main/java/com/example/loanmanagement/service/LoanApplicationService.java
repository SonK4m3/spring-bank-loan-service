package com.example.loanmanagement.service;

import com.example.loanmanagement.entity.EInterestCalculator;
import com.example.loanmanagement.entity.LoanApplication;
import com.example.loanmanagement.entity.LoanInfo;
import com.example.loanmanagement.repository.LoanApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanApplicationService {
    private final LoanApplicationRepository loanApplicationRepository;

    @Autowired
    public LoanApplicationService(LoanApplicationRepository loanApplicationRepository) {
        this.loanApplicationRepository = loanApplicationRepository;
    }

    public List<LoanApplication> getAllLoanApplications() {
        return loanApplicationRepository.findAll();
    }

    public LoanApplication getLoanApplicationById(Long id) {
        return loanApplicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan application not found with id: " + id));
    }

    public LoanApplication saveLoanApplication(LoanApplication loanApplication) {
        return loanApplicationRepository.save(loanApplication);
    }

    public void deleteLoanApplication(Long id) {
        loanApplicationRepository.deleteById(id);
    }

    public double calculateInterest(Long id, EInterestCalculator type) {
        LoanApplication loanApplication = loanApplicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan application not found with id: " + id));
        LoanInfo loanInfo = loanApplication.getLoanInfo();
        // Calculate interest based on the provided loan information
        return (type == EInterestCalculator.SIMPLE) ? calculateSimpleInterest(loanInfo) : calculateCompoundInterest(loanInfo);
    }

    private double calculateSimpleInterest(LoanInfo loanInfo) {
        double principal = loanInfo.getLoanAmount();
        double rate = (loanInfo.getLoanInterestRate() + loanInfo.getInterestRateMargin()) / 100; // Add interest margin
        int term = loanInfo.getLoanTerm();

        return principal * rate * term;
    }

    // Function to calculate compound interest
    private double calculateCompoundInterest(LoanInfo loanInfo) {
        double principal = loanInfo.getLoanAmount();
        double rate = (loanInfo.getLoanInterestRate() + loanInfo.getInterestRateMargin()) / 100; // Add interest margin
        int term = loanInfo.getLoanTerm();

        return principal * (Math.pow((1 + rate), term)) - principal;
    }
}
