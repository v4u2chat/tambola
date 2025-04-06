package com.sahaj.assignments.tambola.rules;

import com.sahaj.assignments.tambola.Ticket;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EarlyFiveRule implements GameRule {
    @Override
    public boolean validateClaim(Ticket ticket, List<Integer> announcedNumbers, Integer lastAnnounced) {
        Set<Integer> allNumbers = ticket.getAllNumbers();
        Set<Integer> announcedSet = new HashSet<>(announcedNumbers);
        int matchedCount = 0;
        for (Integer num : allNumbers) {
            if (announcedSet.contains(num)) matchedCount++;
        }
        return matchedCount >= 5 && allNumbers.contains(lastAnnounced);
    }
}

