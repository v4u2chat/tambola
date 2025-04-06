package com.sahaj.assignments.tambola.rules;

import com.sahaj.assignments.tambola.Ticket;

import java.util.List;
import java.util.Set;

public class MiddleLineRule implements GameRule {
    @Override
    public boolean validateClaim(Ticket ticket, List<Integer> announcedNumbers, Integer lastAnnounced) {
        Set<Integer> middleRow = ticket.getRowNumbers(1);
        return isWinningClaim(middleRow, announcedNumbers, lastAnnounced);
    }
}