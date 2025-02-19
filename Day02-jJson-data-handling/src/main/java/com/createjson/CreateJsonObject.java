package com.createjson;
import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJsonObject {
    public static void main(String[] args)
    {
        JSONArray subjects = new JSONArray();
        subjects.put("mathematics");
        subjects.put("physics");
        subjects.put("chemistry");

        JSONObject user = new JSONObject();
        user.put("name" ,"Alice");
        user.put("age",12);
        user.put("subjects",subjects);

        System.out.println(user.toString(3));

    }
}
