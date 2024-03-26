package com.example.loanmanagement.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "loan_disbursement")
public class LoanDisbursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "loan_application_id", nullable = false)
    private LoanApplication loanApplication;

    @Column(name = "disbursement_date", nullable = false)
    private Date disbursementDate;

    @Column(name = "monthly_repayment_day", nullable = false)
    private int monthlyRepaymentDay;

//    @ManyToOne
//    @JoinColumn(name = "disbursement_account_id", nullable = false)
//    private AccountInfo disbursementAccount;

    public LoanDisbursement() {
    }

    public LoanDisbursement(LoanApplication loanApplication, Date disbursementDate, int monthlyRepaymentDay, AccountInfo disbursementAccount) {
        this.loanApplication = loanApplication;
        this.disbursementDate = disbursementDate;
        this.monthlyRepaymentDay = monthlyRepaymentDay;
//        this.disbursementAccount = disbursementAccount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LoanApplication getLoanApplication() {
        return loanApplication;
    }

    public void setLoanApplication(LoanApplication loanApplication) {
        this.loanApplication = loanApplication;
    }

    public Date getDisbursementDate() {
        return disbursementDate;
    }

    public void setDisbursementDate(Date disbursementDate) {
        this.disbursementDate = disbursementDate;
    }

    public int getMonthlyRepaymentDay() {
        return monthlyRepaymentDay;
    }

    public void setMonthlyRepaymentDay(int monthlyRepaymentDay) {
        this.monthlyRepaymentDay = monthlyRepaymentDay;
    }

//    public AccountInfo getDisbursementAccount() {
//        return disbursementAccount;
//    }
//
//    public void setDisbursementAccount(AccountInfo disbursementAccount) {
//        this.disbursementAccount = disbursementAccount;
//    }
}
