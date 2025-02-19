package com.listofobjectstojson;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

class Car{
    private String brand;
    private String model;
    private int year;

    public Car(){}

    public Car(String brand,String model, int year)
    {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    public String getBrand(){
        return brand;
    }

    public String getModel()
    {
        return model;
    }

    public int getYear()
    {
        return year;
    }
}

public class ListToJsonArray {
    public static void main(String[] args)
    {
        try{
            List<Car> cars = Arrays.asList(
                   new Car("Toyota","camry",2022),
                   new Car("Honda","civic",2023),
                   new Car("Ford","Mustang",2021)
            );

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writeValueAsString(cars);

            System.out.println(jsonArray);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
