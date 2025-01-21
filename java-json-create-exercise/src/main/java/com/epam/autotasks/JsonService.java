package com.epam.autotasks;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;

public class JsonService {

    @SneakyThrows
    public void createAnimalJson(String filePath, List<Animal> animals) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.setSerializationInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL);

        try{
            objectMapper.writeValue(new File(filePath), animals);
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
