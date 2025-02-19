package com.mergejson;
import org.json.JSONObject;
public class MergeJsonExample {
    public static void main(String[] args)
    {
        JSONObject json1 = new JSONObject();
        json1.put("name","Vishal");
        json1.put("gender","male");
        json1.put("age",20);

        JSONObject json2 = new JSONObject();
        json2.put("city","indore");
        json2.put("street", "jawahar street");

        for(String key : json2.keySet())
        {
            json1.put(key,json2.get(key));
        }

        System.out.println("Merged JSON: "+json1.toString(5));
    }
}
