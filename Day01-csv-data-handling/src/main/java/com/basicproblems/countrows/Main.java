package com.basicproblems.countrows;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args)
    {
        String filepath = "C:\\Users\\asus\\OneDrive\\Desktop\\Daily Learning notes\\text.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
            int rowcount = 0;
            String line;
            boolean isHeader = true;

            while((line = br.readLine()) != null)
            {
                if(isHeader)
                {
                    isHeader = false;
                    continue;
                }
                rowcount++;
            }
            System.out.println("Number of records(excluding header): " + rowcount);
        }
        catch (IOException e)
        {
            System.out.println("Error reading csv file: " + e.getMessage());
        }

    }
}
