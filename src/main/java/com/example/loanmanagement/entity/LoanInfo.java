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
    @Column(name = "interest_rate")
    private double interestRate;

    public LoanInfo() {
    }

    public LoanInfo(double loanAmount, int loanTerm, double interestRate) {
        this.loanAmount = loanAmount;
        this.loanTerm = loanTerm;
        this.interestRate = interestRate;
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

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
