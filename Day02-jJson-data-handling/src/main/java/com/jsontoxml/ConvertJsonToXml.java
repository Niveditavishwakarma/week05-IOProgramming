package com.jsontoxml;
import org.json.JSONObject;
import org.json.XML;
public class ConvertJsonToXml {
        public static void main(String[] args) {
            String jsonString = "{"
                    + "\"employee\": {"
                    + "   \"name\": \"John Doe\","
                    + "   \"age\": 30,"
                    + "   \"email\": \"john@example.com\","
                    + "   \"department\": \"IT\""
                    + "}"
                    + "}";

            JSONObject json = new JSONObject(jsonString);
            String xml = XML.toString(json, "root");
            System.out.println(xml);
        }
    }


