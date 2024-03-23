package com.example.loanmanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "loan_application")
public class LoanApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_info_id")
    private PersonalInfo personalInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_info_id")
    private AccountInfo accountInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "loan_info_id")
    private LoanInfo loanInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "branch_info_id")
    private BranchInfo branchInfo;

    @Column(name = "reference_number")
    private String referenceNumber;

    public LoanApplication(PersonalInfo personalInfo, AccountInfo accountInfo, LoanInfo loanInfo, BranchInfo branchInfo, String referenceNumber) {
        this.personalInfo = personalInfo;
        this.accountInfo = accountInfo;
        this.loanInfo = loanInfo;
        this.branchInfo = branchInfo;
        this.referenceNumber = referenceNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public LoanInfo getLoanInfo() {
        return loanInfo;
    }

    public void setLoanInfo(LoanInfo loanInfo) {
        this.loanInfo = loanInfo;
    }

    public BranchInfo getBranchInfo() {
        return branchInfo;
    }

    public void setBranchInfo(BranchInfo branchInfo) {
        this.branchInfo = branchInfo;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }
}
