package com.intermediateproblems.modifycsv;
import java.io.*;
import java.util.*;
public class ModifyCSV {
    public static void main(String[] args) {
        String employeeFile = "C:\\Users\\asus\\OneDrive\\Desktop\\Daily Learning notes\\employees.csv";
        String updatedEmployeeFile = "C:\\Users\\asus\\OneDrive\\Desktop\\Daily Learning notes\\updated_employees.csv";
        List<String> updatedLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(employeeFile))) {
            String line;
            boolean isHeader = true;

            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    updatedLines.add(line);
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data[2].equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(data[3]);
                    salary *= 1.10;
                    data[3] = String.format("%.2f", salary);
                }
                updatedLines.add(String.join(",", data));
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }

        try (FileWriter writer = new FileWriter(updatedEmployeeFile)) {
            for (String updatedLine : updatedLines) {
                writer.append(updatedLine).append("\n");
            }
            System.out.println("Updated employee CSV file created successfully!");
        } catch (IOException e) {
            System.err.println("Error writing updated CSV file: " + e.getMessage());
        }
    }
}


