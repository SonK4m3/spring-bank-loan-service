package com.example.loanmanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "loan_info")
public class LoanInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ELoanPurpose purpose;
    private double loanAmount;
    private ELoanTerm term;
    private double interestRate;
    private EPaymentMethod paymentMethod;

    public LoanInfo(ELoanPurpose purpose, double loanAmount, ELoanTerm term, double interestRate, EPaymentMethod paymentMethod) {
        this.purpose = purpose;
        this.loanAmount = loanAmount;
        this.term = term;
        this.interestRate = interestRate;
        this.paymentMethod = paymentMethod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ELoanPurpose getPurpose() {
        return purpose;
    }

    public void setPurpose(ELoanPurpose purpose) {
        this.purpose = purpose;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public ELoanTerm getTerm() {
        return term;
    }

    public void setTerm(ELoanTerm term) {
        this.term = term;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public EPaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(EPaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
