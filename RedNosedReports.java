/**
  Advent of Code 2024 - Day 2: Red-Nosed Reports
 
  This program counts how many reports are "safe".
 A report is safe if:
  1. Levels are strictly increasing or strictly decreasing
  2. Difference between adjacent levels is between 1 and 3
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RedNosedReports {

    private static final int MIN_DIFFERENCE = 1;
    private static final int MAX_DIFFERENCE = 3;

    public static void main(String[] args) {
        String fileName = args.length > 0 ? args[0] : "input.txt";

        try {
            int safeReportCount = countSafeReports(fileName);
            System.out.println(safeReportCount);
        } catch (IOException exception) {
            System.err.println("Error reading file: " + exception.getMessage());
        }
    }
/*
  Reads the input file line by line.  Each line represents a report.
  Parses each report into numbers and checks if it is safe.
  Returns the total number of safe reports.
 */

    private static int countSafeReports(String fileName) throws IOException {
        int safeReportCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String reportLine;

            while ((reportLine = reader.readLine()) != null) {
                if (reportLine.isBlank()) {
                    continue;
                }

                int[] levels = parseLevels(reportLine);

                if (isSafeReport(levels)) {
                    safeReportCount++;
                }
            }
        }

        return safeReportCount;
    }
/*
  Converts a single line of space-separated numbers
  into an integer array representing report levels.
 */
    private static int[] parseLevels(String reportLine) {
        String[] parts = reportLine.trim().split("\\s+");
        int[] levels = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            levels[i] = Integer.parseInt(parts[i]);
        }

        return levels;
    }
 /*
    Checks if a report is safe based on problem rules
 */ 

    private static boolean isSafeReport(int[] levels) {
        if (levels.length < 2) {
            return true;
        }

        int firstDifference = levels[1] - levels[0];

        if (!isValidDifference(firstDifference)) {
            return false;
        }

        boolean shouldIncrease = firstDifference > 0;

        for (int i = 1; i < levels.length - 1; i++) {
            int difference = levels[i + 1] - levels[i];

            if (!isValidDifference(difference)) {
                return false;
            }

            if (shouldIncrease && difference < 0) {
                return false;
            }

            if (!shouldIncrease && difference > 0) {
                return false;
            }
        }

        return true;
    }
/*
  Checks if the difference between two adjacent levels is within the allowed range [1, 3].
 */
    private static boolean isValidDifference(int difference) {
        int absoluteDifference = Math.abs(difference);
        return absoluteDifference >= MIN_DIFFERENCE && absoluteDifference <= MAX_DIFFERENCE;
    }
}