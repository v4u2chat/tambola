package com.sahaj.assignments.tambola.rules;

import com.sahaj.assignments.tambola.Ticket;

import java.util.List;
import java.util.Set;

public class FullHouseRule implements GameRule {
    @Override
    public boolean validateClaim(Ticket ticket, List<Integer> announcedNumbers, Integer lastAnnounced) {
        Set<Integer> allNumbers = ticket.getAllNumbers();
        return isWinningClaim(allNumbers, announcedNumbers, lastAnnounced);
    }
}