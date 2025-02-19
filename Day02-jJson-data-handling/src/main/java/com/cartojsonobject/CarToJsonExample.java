package com.cartojsonobject;
import org.json.JSONObject;
public class CarToJsonExample {
    public static void main(String[] agrs)
    {
        Car car = new Car("Toyota","camry",2020);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("brand",car.getBrand());
        jsonObject.put("model",car.getModel());
        jsonObject.put("year",car.getYear());

        System.out.println(jsonObject.toString(4));

    }
}
