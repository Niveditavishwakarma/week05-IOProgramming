package com.intermediateproblems.searchrecords;
import java.io.*;
import java.util.Scanner;
public class SearchRecords {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine();
        scanner.close();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/asus/OneDrive/Desktop/Daily Learning notes/employees.csv"))) {
            String line;
            boolean isHeader = true;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data[1].equalsIgnoreCase(searchName)) {
                    System.out.println("Department: " + data[2] + ", Salary: " + data[3]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }
}

