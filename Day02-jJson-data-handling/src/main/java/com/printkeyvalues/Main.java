package com.printkeyvalues;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class Main {
        public static void main(String[] args) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();

                File file = new File("C:\\Users\\asus\\OneDrive\\Desktop\\Daily Learning notes\\data.json");
                JsonNode rootNode = objectMapper.readTree(file);

                printJsonKeysAndValues(rootNode, "");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void printJsonKeysAndValues(JsonNode node,String parentKey)

        {
            if (node.isObject()) {
                Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
                while (fields.hasNext()) {
                    Map.Entry<String, JsonNode> field = fields.next();
                    printJsonKeysAndValues(field.getValue(), parentKey + field.getKey() + ".");
                }
            }
            else if (node.isArray()) {
                for (int i = 0; i < node.size(); i++) {
                    printJsonKeysAndValues(node.get(i), parentKey + "[" + i + "].");
                }
            }
            else {
                System.out.println(parentKey.substring(0, parentKey.length() - 1) + " = " + node.asText());
            }
        }
}


