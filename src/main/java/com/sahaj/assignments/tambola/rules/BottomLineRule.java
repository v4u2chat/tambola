package com.sahaj.assignments.tambola.rules;

import com.sahaj.assignments.tambola.Ticket;

import java.util.List;
import java.util.Set;

public class BottomLineRule implements GameRule {
    @Override
    public boolean validateClaim(Ticket ticket, List<Integer> announcedNumbers, Integer lastAnnounced) {
        Set<Integer> bottomRow = ticket.getRowNumbers(2);
        return isWinningClaim(bottomRow, announcedNumbers, lastAnnounced);
    }
}