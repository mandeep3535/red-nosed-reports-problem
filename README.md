# Advent of Code 2024 - Day 2: Red-Nosed Reports

##  Problem Overview

This project solves **Day 2: Red-Nosed Reports** from Advent of Code 2024.

Each line in the input file represents a report containing space-separated numbers called *levels*.

A report is considered **safe** if:

1. The levels are strictly **increasing** or strictly **decreasing**
2. The difference between any two adjacent levels is between **1 and 3** (inclusive)

---

##  Approach

- Read the input file line by line
- Convert each line into an array of integers
- Check:
  - If the sequence is fully increasing or decreasing
  - If all adjacent differences are within the valid range (1–3)
- Count how many reports satisfy both conditions

---

##  Technologies Used

- Java
- File I/O (BufferedReader)
