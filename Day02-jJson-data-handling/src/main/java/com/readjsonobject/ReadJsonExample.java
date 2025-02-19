package com.readjsonobject;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class ReadJsonExample {
    public static void main(String[] a)
    {
        String filepath = "C:\\Users\\asus\\OneDrive\\Desktop\\Daily Learning notes\\data.json";
        try{
            String content = new String(Files.readAllBytes(Paths.get(filepath)));
            JSONObject jsonobject = new JSONObject(content);
            String name = jsonobject.getString("name");
            String email = jsonobject.getString("email");

            System.out.println("Name: " + name);
            System.out.println("email: " + email);

        }
        catch(NoSuchFileException e)
        {
            System.out.println("Error: File not found! check the file path" + filepath);
        }
        catch(IOException e)
        {
            System.out.println("Error: unable to read file");
        }
        catch(Exception e)
        {
            System.out.println("Error: invalid json format");
            e.printStackTrace();
        }
    }
}
