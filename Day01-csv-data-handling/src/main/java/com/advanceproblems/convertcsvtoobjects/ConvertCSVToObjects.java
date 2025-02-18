package com.advanceproblems.convertcsvtoobjects;
import java.io.*;
import java.util.*;
public class ConvertCSVToObjects {
    public static void main(String[] args) {
        String csvFile = "C:\\Users\\asus\\OneDrive\\Desktop\\Daily Learning notes\\student.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            boolean isHeader = true;

            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length < 4) {
                    System.err.println("Invalid row: " + line);
                    continue;
                }

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                double marks = Double.parseDouble(data[3]);

                students.add(new Student(id, name, age, marks));
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error processing CSV file: " + e.getMessage());
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
