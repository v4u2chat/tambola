package com.sahaj.assignments.tambola;

import com.sahaj.assignments.tambola.rules.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClaimValidator {
    private final Map<String, GameRule> gameRules;

    public ClaimValidator() {
        gameRules = new HashMap<>();
        gameRules.put("TR", new TopLineRule());
        gameRules.put("MR", new MiddleLineRule());
        gameRules.put("BR", new BottomLineRule());
        gameRules.put("FH", new FullHouseRule());
        gameRules.put("EF", new EarlyFiveRule());
    }

    public String validate(Ticket ticket, List<Integer> announcedNumbers, String claimType) {
        GameRule rule = gameRules.get(claimType);
        if (rule == null) {
            return "Rejected - Invalid claim type";
        }

        Integer lastAnnounced = announcedNumbers.get(announcedNumbers.size() - 1);
        return rule.validateClaim(ticket, announcedNumbers, lastAnnounced) ? "Accepted" : "Rejected";
    }

}
