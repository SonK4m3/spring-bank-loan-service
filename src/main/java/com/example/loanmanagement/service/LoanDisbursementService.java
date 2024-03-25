package com.example.loanmanagement.service;

import com.example.loanmanagement.entity.LoanDisbursement;
import com.example.loanmanagement.repository.LoanDisbursementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanDisbursementService {

    @Autowired
    private LoanDisbursementRepository loanDisbursementRepository;

    public LoanDisbursement createLoanDisbursement(LoanDisbursement loanDisbursement) {
        // Implement logic to create a new loan disbursement
        return loanDisbursementRepository.save(loanDisbursement);
    }

    public Optional<LoanDisbursement> getLoanDisbursementById(Long id) {
        return loanDisbursementRepository.findById(id);
    }

    public List<LoanDisbursement> getAllLoanDisbursements() {
        return loanDisbursementRepository.findAll();
    }

    public void deleteLoanDisbursement(Long id) {
        loanDisbursementRepository.deleteById(id);
    }
}