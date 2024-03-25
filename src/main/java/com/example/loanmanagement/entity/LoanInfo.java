package com.example.loanmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "loan_info")
public class LoanInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "loan_amount")
    private double loanAmount;

    @NotNull
    @Column(name = "loan_term")
    private int loanTerm;

    @NotNull
    @Column(name = "current_earning")
    private double currentEearning;

    @Column(name = "loan_interest_rate")
    private double loanInterestRate = 0.06; // Default value: 6%

    @Column(name = "interest_rate_margin")
    private double interestRateMargin = 0.04; // Default value: 4%

    public LoanInfo() {
    }

    public LoanInfo(@NotNull double loanAmount, @NotNull int loanTerm, @NotNull double currentEearning, double loanInterestRate, double interestRateMargin) {
        this.loanAmount = loanAmount;
        this.loanTerm = loanTerm;
        this.currentEearning = currentEearning;
        this.loanInterestRate = loanInterestRate;
        this.interestRateMargin = interestRateMargin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    public double getCurrentEearning() {
        return currentEearning;
    }

    public void setCurrentEearning(double currentEearning) {
        this.currentEearning = currentEearning;
    }

    public double getLoanInterestRate() {
        return loanInterestRate;
    }

    public void setLoanInterestRate(double loanInterestRate) {
        this.loanInterestRate = loanInterestRate;
    }

    public double getInterestRateMargin() {
        return interestRateMargin;
    }

    public void setInterestRateMargin(double interestRateMargin) {
        this.interestRateMargin = interestRateMargin;
    }
}
