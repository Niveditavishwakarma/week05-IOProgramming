package com.csvtojson;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.util.List;
import java.util.Map;
public class ConvertCSVToJson {
    public static void main(String[] args) {
        try {
            File csvFile = new File("C:\\Users\\asus\\OneDrive\\Desktop\\Daily Learning notes\\employees.csv");
            CsvSchema schema = CsvSchema.emptySchema().withHeader();
            CsvMapper csvMapper = new CsvMapper();
            MappingIterator<Map<String, String>> it = csvMapper.readerFor(Map.class)
                    .with(schema)
                    .readValues(csvFile);

            List<Map<String, String>> csvData = it.readAll();
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(csvData);

            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
