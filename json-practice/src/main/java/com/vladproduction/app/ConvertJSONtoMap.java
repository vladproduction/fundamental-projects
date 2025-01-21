package com.vladproduction.app;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ConvertJSONtoMap {
    public static void main(String[] args) throws IOException {
        //converting json to Map
        byte[] mapData = Files.readAllBytes(Paths.get("data.txt"));
        Map<String,String> myMap = new HashMap<String, String>();

        ObjectMapper objectMapper = new ObjectMapper();
        myMap = objectMapper.readValue(mapData, HashMap.class);
        System.out.println("Map is: "+myMap);

        //another way
        myMap = objectMapper.readValue(mapData, new TypeReference<HashMap<String,String>>() {});
        System.out.println("Map using TypeReference: "+myMap);
    }
}
