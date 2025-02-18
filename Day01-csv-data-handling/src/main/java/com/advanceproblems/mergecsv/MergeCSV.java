package com.advanceproblems.mergecsv;
import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) {
        String file1 = "C:\\Users\\asus\\OneDrive\\Desktop\\Daily Learning notes\\students1.csv";
        String file2 = "C:\\Users\\asus\\OneDrive\\Desktop\\Daily Learning notes\\studetns2.csv";
        String outputFile = "C:\\Users\\asus\\OneDrive\\Desktop\\Daily Learning notes\\merge_students.csv";

        Map<String, String[]> students1Map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String name = data[1];
                String age = data[2];
                students1Map.put(id, new String[]{name, age});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();

            try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    String id = data[0];
                    String marks = data[1];
                    String grade = data[2];

                    if (students1Map.containsKey(id)) {
                        String[] student1Details = students1Map.get(id);
                        String name = student1Details[0];
                        String age = student1Details[1];

                        bw.write(String.join(",", id, name, age, marks, grade));
                        bw.newLine();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Files merged successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
