package com.validateemail;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ValidateEmailJson {
    public static void main(String[] args) {
        String schemaString = "{"
                + "\"type\": \"object\","
                + "\"properties\": {"
                + "    \"name\": {\"type\": \"string\"},"
                + "    \"email\": {\"type\": \"string\", \"format\": \"email\"}"
                + "},"
                + "\"required\": [\"name\", \"email\"]"
                + "}";

        String jsonString = "{ \"name\": \"Alice\", \"email\": \"alice@example.com\" }";

        try {
            JSONObject schemaJson = new JSONObject(new JSONTokener(schemaString));
            JSONObject jsonData = new JSONObject(new JSONTokener(jsonString));

            Schema schema = SchemaLoader.load(schemaJson);

            schema.validate(jsonData);
            System.out.println("JSON is valid!");

        } catch (Exception e) {
            System.out.println("JSON Validation Failed: " + e.getMessage());
        }
    }
}

