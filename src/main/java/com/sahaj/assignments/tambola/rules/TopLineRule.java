package com.sahaj.assignments.tambola.rules;

import com.sahaj.assignments.tambola.Ticket;

import java.util.List;
import java.util.Set;

public class TopLineRule implements GameRule {
    @Override
    public boolean validateClaim(Ticket ticket, List<Integer> announcedNumbers, Integer lastAnnounced) {
        Set<Integer> topRow = ticket.getRowNumbers(0);
        return isWinningClaim(topRow, announcedNumbers, lastAnnounced);
    }
}
