package com.donation;

public class Donation {
    private String donationId;
    private double amount;
    private String donorName;
    private boolean processed;

    public Donation(String donationId, double amount, String donorName) {
        this.donationId = donationId;
        this.amount = amount;
        this.donorName = donorName;
        this.processed = false;
    }

    public String getDonationId() {
        return donationId;
    }

    public double getAmount() {
        return amount;
    }

    public String getDonorName() {
        return donorName;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }
}
