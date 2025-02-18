package com.basicproblems.readcsv;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class CSVReader {
    public static void main(String[] args)
    {
        String filepath = "C:\\Users\\asus\\OneDrive\\Desktop\\Daily Learning notes\\student.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
           String line;
           boolean isFirstLine = true;
           while((line = br.readLine()) != null)
           {
               if(isFirstLine)
               {
                   isFirstLine = false;
                   continue;
               }
                String[] student = line.split(",");
               System.out.println("ID: " + student[0] + ", Name: " + student[1] + ", Age: " + student[2] + ", Marks: " + student[3]);
           }

        }
        catch(IOException e)
        {
                e.printStackTrace();
        }
    }
}
