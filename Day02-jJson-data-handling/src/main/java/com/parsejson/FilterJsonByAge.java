package com.parsejson;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.util.stream.Collectors;
public class FilterJsonByAge {
    public static void main(String[] args) {
        String jsonArray = "[{\"name\":\"Alice\",\"age\":30,\"email\":\"alice@example.com\"}," +
                "{\"name\":\"Bob\",\"age\":22,\"email\":\"bob@example.com\"}," +
                "{\"name\":\"Charlie\",\"age\":28,\"email\":\"charlie@example.com\"}]";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Person> people = objectMapper.readValue(jsonArray, new TypeReference<List<Person>>() {});
            List<Person> filteredPeople = people.stream()
                    .filter(person -> person.getAge() > 25)
                    .collect(Collectors.toList());

            String filteredJson = objectMapper.writeValueAsString(filteredPeople);

            System.out.println("Filtered People (Age > 25): " + filteredJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
