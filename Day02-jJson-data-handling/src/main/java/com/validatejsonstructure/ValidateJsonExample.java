package com.validatejsonstructure;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJsonExample {
    public static void main(String[] args) {
        String jsonString = "{ \"name\": \"John Doe\", \"email\": \"johndoe@example.com\", \"age\": 30 }";

        if (isValidJson(jsonString)) {
            System.out.println("Valid JSON structure");
        } else {
            System.out.println("Invalid JSON structure");
        }
    }

    public static boolean isValidJson(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.readTree(json);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}







