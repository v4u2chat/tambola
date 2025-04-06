package com.sahaj.assignments.tambola;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ClaimValidatorTest extends TestCase {
    private ClaimValidator validator;
    private Ticket ticket;
    private List<Integer> announcedNumbersAccepted; // From Example 1
    private List<Integer> announcedNumbersRejected; // From Example 2

    @Before
    public void setUp() {
        // Initialize validator
        validator = new ClaimValidator();

        // Same ticket from TambolaGame.java
        int[][] ticketNumbers = {
                {4, 16, 0, 48, 63, 76, 0, 0, 0},
                {7, 0, 23, 38, 0, 52, 0, 80, 0},
                {9, 0, 25, 0, 56, 64, 0, 83, 0}
        };
        ticket = new Ticket(ticketNumbers);

        // Same announced numbers from examples
        announcedNumbersAccepted = Arrays.asList(90, 4, 46, 63, 89, 16, 76, 48); // TR complete
        announcedNumbersRejected = Arrays.asList(90, 4, 46, 63, 89, 16, 76, 48, 12); // Late claim
    }

    @Test
    public void testTopLineAccepted() {
        String result = validator.validate(ticket, announcedNumbersAccepted, "TR");
        assertEquals("Accepted", result);
    }

    @Test
    public void testTopLineRejectedLateClaim() {
        String result = validator.validate(ticket, announcedNumbersRejected, "TR");
        assertEquals("Rejected", result);
    }

    @Test
    public void testMiddleLineNotComplete() {
        // MR (7, 23, 38, 52, 80) - only 7 and 23 present in announcedNumbersAccepted
        String result = validator.validate(ticket, announcedNumbersAccepted, "MR");
        assertEquals("Rejected", result);
    }

    @Test
    public void testBottomLineNotComplete() {
        // Bottom row (9, 25, 56, 64, 83) - only 9 present in announcedNumbersAccepted
        String result = validator.validate(ticket, announcedNumbersAccepted, "BR");
        assertEquals("Rejected", result);
    }

    @Test
    public void testFullHouseNotComplete() {
        // Full house needs all 15 numbers, but only 8 announced in accepted case
        String result = validator.validate(ticket, announcedNumbersAccepted, "FH");
        assertEquals("Rejected", result);
    }

    @Test
    public void testEarlyFiveAccepted() {
        // Early Five needs 5 numbers; announcedNumbersAccepted has 6 from ticket (4, 16, 48, 63, 76, 46)
        // Last number 48 is in ticket, so claim is valid
        String result = validator.validate(ticket, announcedNumbersAccepted, "EF");
        assertEquals("Accepted", result);
    }

    @Test
    public void testEarlyFiveRejectedLateClaim() {
        // Last number 12 not in ticket, so claim after 12 is invalid
        String result = validator.validate(ticket, announcedNumbersRejected, "EF");
        assertEquals("Rejected", result);
    }
}