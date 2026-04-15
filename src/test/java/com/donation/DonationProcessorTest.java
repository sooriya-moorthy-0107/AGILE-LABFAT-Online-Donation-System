package com.donation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DonationProcessorTest {

    private DonationProcessor processor;

    @BeforeEach
    public void setUp() {
        processor = new DonationProcessor();
    }

    @Test
    public void testValidDonationProcess() {
        Donation donation = new Donation("TXN-001", 100.50, "Alice Smith");
        boolean result = processor.processDonation(donation);
        
        assertTrue(result, "Valid donation should be processed successfully.");
        assertTrue(donation.isProcessed(), "Processed flag should be set to true.");
    }

    @Test
    public void testInvalidDonationZeroAmount() {
        Donation donation = new Donation("TXN-002", 0.0, "Bob Jones");
        boolean result = processor.processDonation(donation);
        
        assertFalse(result, "Zero amount donation should fail validation.");
        assertFalse(donation.isProcessed(), "Processed flag should remain false.");
    }

    @Test
    public void testInvalidDonationNegativeAmount() {
        Donation donation = new Donation("TXN-003", -50.0, "Charlie Brown");
        boolean result = processor.processDonation(donation);
        
        assertFalse(result, "Negative amount donation should fail validation.");
        assertFalse(donation.isProcessed(), "Processed flag should remain false.");
    }

    @Test
    public void testInvalidDonationEmptyDonorName() {
        Donation donation = new Donation("TXN-004", 25.0, "   ");
        boolean result = processor.processDonation(donation);
        
        assertFalse(result, "Empty donor name should fail validation.");
        assertFalse(donation.isProcessed(), "Processed flag should remain false.");
    }

    @Test
    public void testInvalidNullDonation() {
        boolean result = processor.processDonation(null);
        assertFalse(result, "Null donation should fail validation.");
    }
}
