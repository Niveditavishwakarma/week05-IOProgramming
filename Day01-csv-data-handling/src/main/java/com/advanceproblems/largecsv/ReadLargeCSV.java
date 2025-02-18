package com.advanceproblems.largecsv;
import java.io.*;
public class ReadLargeCSV {

        public static void main(String[] args) {
            String filePath = "C:\\Users\\asus\\Downloads\\100mb.csv";
            int chunkSize = 100;
            int recordCount = 0;

            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                int linesProcessed = 0;

                while ((line = br.readLine()) != null) {
                    linesProcessed++;

                    System.out.println(line);

                    if (linesProcessed == chunkSize) {
                        recordCount += linesProcessed;
                        System.out.println("Processed " + recordCount + " records so far...");
                        linesProcessed = 0;
                    }
                }

                if (linesProcessed > 0) {
                    recordCount += linesProcessed;
                    System.out.println("Processed " + recordCount + " records in total.");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


