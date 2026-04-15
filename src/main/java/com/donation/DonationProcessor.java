package com.donation;

public class DonationProcessor {

    /**
     * Processes a donation and validates its properties.
     * @param donation The donation to process
     * @return true if valid and processed successfully, false otherwise
     */
    public boolean processDonation(Donation donation) {
        if (donation == null) {
            return false;
        }

        // Validate Amount: Donation must be strictly greater than 0
        if (donation.getAmount() <= 0) {
            return false;
        }

        // Validate Donor Name: Should not be null or empty
        if (donation.getDonorName() == null || donation.getDonorName().trim().isEmpty()) {
            return false;
        }

        // Process successful
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
