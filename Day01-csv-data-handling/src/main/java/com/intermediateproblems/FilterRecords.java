package com.intermediateproblems;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class FilterRecords {
    public static void main(String[] args)
    {
        String filepath = "C:\\Users\\asus\\OneDrive\\Desktop\\Daily Learning notes\\student.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            boolean isHeader = true;

            System.out.println("Students with marks greater than 80:");
            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                int marks = Integer.parseInt(data[3]);
                if (marks > 80) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }

}
