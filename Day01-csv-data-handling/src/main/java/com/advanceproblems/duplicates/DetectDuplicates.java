package com.advanceproblems.duplicates;
import java.io.*;
import java.util.*;

public class DetectDuplicates {

        public static void main(String[] args) {
            String filePath = "C:\\Users\\asus\\OneDrive\\Desktop\\Daily Learning notes\\file.csv";
            Set<String> seenIDs = new HashSet<>();
            List<String> duplicates = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                br.readLine();

                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    String id = data[0];

                    if (seenIDs.contains(id)) {
                        duplicates.add(line);
                    } else {
                        seenIDs.add(id);
                    }
                }

                if (duplicates.isEmpty()) {
                    System.out.println("No duplicates found.");
                } else {
                    System.out.println("Duplicate records:");
                    for (String duplicate : duplicates) {
                        System.out.println(duplicate);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


