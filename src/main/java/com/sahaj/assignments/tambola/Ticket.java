package com.sahaj.assignments.tambola;

import java.util.HashSet;
import java.util.Set;

public record Ticket(int[][] numbers) {
    private static final int ROWS = 3;
    private static final int COLS = 5;

    public Set<Integer> getAllNumbers() {
        Set<Integer> allNumbers = new HashSet<>();
        for (int[] row : numbers) {
            for (int num : row) {
                if (num != 0) allNumbers.add(num);
            }
        }
        return allNumbers;
    }

    public Set<Integer> getRowNumbers(int rowIndex) {
        Set<Integer> rowNumbers = new HashSet<>();
        for (int num : numbers[rowIndex]) {
            if (num != 0) rowNumbers.add(num);
        }
        return rowNumbers;
    }
}