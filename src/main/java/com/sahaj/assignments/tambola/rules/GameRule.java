package com.sahaj.assignments.tambola.rules;

import com.sahaj.assignments.tambola.Ticket;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Game interface for Strategy pattern
public interface GameRule {
    boolean validateClaim(Ticket ticket, List<Integer> announcedNumbers, Integer lastAnnounced);

    default boolean isWinningClaim(Set<Integer> requiredNumbers, List<Integer> announcedNumbers, Integer lastAnnounced) {
        Set<Integer> announcedSet = new HashSet<>(announcedNumbers);
        boolean allNumbersMatched = announcedSet.containsAll(requiredNumbers);
        boolean lastNumberCompletes = requiredNumbers.contains(lastAnnounced);
        return allNumbersMatched && lastNumberCompletes;
    }
}
