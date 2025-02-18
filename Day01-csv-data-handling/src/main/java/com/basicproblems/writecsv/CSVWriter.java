package com.basicproblems.writecsv;
import java.io.*;
public class CSVWriter {
    public static void main(String[] args)
    {
        String filename = "C:\\Users\\asus\\OneDrive\\Desktop\\Daily Learning notes\\text.txt";
        try(FileWriter writer = new FileWriter(filename))
        {
            writer.write("ID,NAME,DEPARTMENT,SALARY\n");

            writer.write("101,John Doe,IT,60000\n");
            writer.write("102,Jane Smith,HR,55000\n");
            writer.write("103,Robert Brown,Finance,65000\n");
            writer.write("104,Emily Davis,Marketing,50000\n");
            writer.write("105,Michael Wilson,Operations,58000\n");
        }
        catch(IOException e)
        {
            System.out.println("Error writing to csv: " + e.getMessage());
        }

    }
}
