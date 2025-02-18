package com.intermediateproblems.sortcsv;
import java.io.*;
import java.util.*;

public class SortCSV {
        public static void main(String[] args) {
            String employeeFile = "C:\\Users\\asus\\OneDrive\\Desktop\\Daily Learning notes\\employees.csv";

            List<String[]> employeeData = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(employeeFile))) {
                String line;
                boolean isHeader = true;

                while ((line = reader.readLine()) != null) {
                    if (isHeader) {
                        isHeader = false;
                        continue;
                    }
                    employeeData.add(line.split(","));
                }
            } catch (IOException e) {
                System.err.println("Error reading CSV file: " + e.getMessage());
            }

            employeeData.sort((a, b) -> Double.compare(Double.parseDouble(b[3]), Double.parseDouble(a[3])));

            System.out.println("Top 5 highest-paid employees:");
            for (int i = 0; i < Math.min(5, employeeData.size()); i++) {
                System.out.println(String.join(", ", employeeData.get(i)));
            }
        }
    }


