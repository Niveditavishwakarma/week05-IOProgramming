package com.advanceproblems.validatephoneandemail;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCSV {
    public static void main(String[] args) {
        String csvFile = "C:\\Users\\asus\\OneDrive\\Desktop\\Daily Learning notes\\data.csv";
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            boolean isHeader = true;

            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length < 3) {
                    System.err.println("Invalid row (missing columns): " + line);
                    continue;
                }

                String email = data[1];
                String phone = data[2];

                if (!emailPattern.matcher(email).matches()) {
                    System.err.println("Invalid email format: " + line);
                }

                if (!phonePattern.matcher(phone).matches()) {
                    System.err.println("Invalid phone number: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
