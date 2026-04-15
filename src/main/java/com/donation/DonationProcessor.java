package com.donation;

public class DonationProcessor {


    public boolean processDonation(Donation donation) {
        if (donation == null) {
            return false;
        }


        if (donation.getAmount() <= 0) {
            return false;
        }


        if (donation.getDonorName() == null || donation.getDonorName().trim().isEmpty()) {
            return false;
        }


        donation.setProcessed(true);
        System.out.println("Donation Processed Successfully: ID=" + donation.getDonationId() + 
                           ", Amount=$" + donation.getAmount() + 
                           ", Donor=" + donation.getDonorName());
        
        return true;
    }

    public static void main(String[] args) {
        DonationProcessor processor = new DonationProcessor();
        Donation myDonation = new Donation("TXN-101", 50.0, "John Doe");
        
        if (processor.processDonation(myDonation)) {
            System.out.println("System initialized and handled first donation.");
        } else {
            System.out.println("Failed to process transaction.");
        }
    }
}
