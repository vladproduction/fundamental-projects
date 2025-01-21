package com.vladproduction.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Jackson JSON - Edit JSON Document
 * Jackson JSON Java API provide useful methods
 * to add, edit and remove
 * keys from JSON data;
 * then we can save it as new json file or write it to any stream. Below code shows us how to do this easily.
 * */
public class MethodsModifiedKeysFromJSON {
    public static void main(String[] args) throws IOException {
        byte[] jsonData = Files.readAllBytes(Paths.get("employee.txt"));

        ObjectMapper objectMapper = new ObjectMapper();

        //configure Object mapper for pretty print
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        //create JsonNode
        JsonNode rootNode = objectMapper.readTree(jsonData);

        //update JSON data
        ((ObjectNode) rootNode).put("id", 500);
        //add new key value
        ((ObjectNode) rootNode).put("test", "test value");
        //remove existing key
        ((ObjectNode) rootNode).remove("role");
        ((ObjectNode) rootNode).remove("properties");
        objectMapper.writeValue(new File("updated_emp.txt"), rootNode);
    }

    /*If you execute above code and look for the new file,
    you will notice that it doesn’t have “role” and “properties” key.
    You will also notice that “id” value is updated to 500 and a new key “test” is added to updated_emp.txt file.*/
}
