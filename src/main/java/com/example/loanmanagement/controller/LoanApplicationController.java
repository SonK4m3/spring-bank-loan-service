package com.example.loanmanagement.controller;

import com.example.loanmanagement.entity.EInterestCalculator;
import com.example.loanmanagement.entity.ELoanStatus;
import com.example.loanmanagement.entity.LoanApplication;
import com.example.loanmanagement.model.payload.response.InterestCalculationResponse;
import com.example.loanmanagement.model.payload.response.MessageResponse;
import com.example.loanmanagement.service.LoanApplicationService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loanApplications")
public class LoanApplicationController {

    @Autowired
    private LoanApplicationService loanApplicationService;

    @GetMapping
    public ResponseEntity<List<LoanApplication>> getAllLoanApplications() {
        List<LoanApplication> loanApplications = loanApplicationService.getAllLoanApplications();
        return new ResponseEntity<>(loanApplications, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanApplication> getLoanApplicationById(@PathVariable Long id) {
        LoanApplication loanApplication = loanApplicationService.getLoanApplicationById(id);
        return new ResponseEntity<>(loanApplication, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LoanApplication> createLoanApplication(@RequestBody LoanApplication loanApplication) {
        LoanApplication createdLoanApplication = loanApplicationService.saveLoanApplication(loanApplication);
        return new ResponseEntity<>(createdLoanApplication, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanApplication> updateLoanApplication(@PathVariable Long id, @RequestBody LoanApplication loanApplication) {
        loanApplication.setId(id);
        LoanApplication updatedLoanApplication = loanApplicationService.saveLoanApplication(loanApplication);
        return new ResponseEntity<>(updatedLoanApplication, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoanApplication(@PathVariable Long id) {
        loanApplicationService.deleteLoanApplication(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/interest/loan/{id}")
    public ResponseEntity<MessageResponse> interestCalculation(@PathVariable Long id, @PathParam("type") EInterestCalculator type) {
        double interest = loanApplicationService.calculateInterest(id, type);
        MessageResponse messageResponse = new MessageResponse("" + interest);
        return new ResponseEntity<>(messageResponse, HttpStatus.OK);
    }

    @PutMapping("/{applicationId}/approve")
    public void approveLoanApplication(@PathVariable Long applicationId) {
        loanApplicationService.updateLoanStatus(applicationId, ELoanStatus.APPROVED);
    }

    @PutMapping("/{applicationId}/deny")
    public void denyLoanApplication(@PathVariable Long applicationId) {
        loanApplicationService.updateLoanStatus(applicationId, ELoanStatus.REJECTED);
    }

    @GetMapping("/interest/based/{id}")
    public ResponseEntity<InterestCalculationResponse> basedInterestCalculation(@PathVariable Long id) {
        InterestCalculationResponse basedInterestCalculationResponse = loanApplicationService.calculateBasedInterestMonthly(id);
        return new ResponseEntity<>(basedInterestCalculationResponse, HttpStatus.OK);
    }

    @GetMapping("/interest/decrease/{id}")
    public ResponseEntity<List<InterestCalculationResponse>> decreaseInterestCalculation(@PathVariable Long id) {
        List<InterestCalculationResponse> basedInterestCalculationResponses = loanApplicationService.calculateDecreasedInterestMonthly(id);
        return new ResponseEntity<>(basedInterestCalculationResponses, HttpStatus.OK);
    }
}