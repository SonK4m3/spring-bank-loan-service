package com.example.loanmanagement.model.payload.response;

public class InterestCalculationResponse {
    private double basedAmount;
    private double interestAmount;
    private double total;

    public InterestCalculationResponse(double basedAmount, double interestAmount) {
        this.basedAmount = basedAmount;
        this.interestAmount = interestAmount;
        this.total = basedAmount + interestAmount;
    }

    public double getBasedAmount() {
        return basedAmount;
    }

    public void setBasedAmount(double basedAmount) {
        this.basedAmount = basedAmount;
    }

    public double getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(double interestAmount) {
        this.interestAmount = interestAmount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
