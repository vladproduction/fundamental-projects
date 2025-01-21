package com.vladproduction.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.vladproduction.model.Address;
import com.vladproduction.model.Person;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class SerializeObjectToJSON {

    private static final Logger log = Logger.getLogger(String.valueOf(SerializeObjectToJSON.class));

    public static void main(String[] args) {

        //version#1 (used: BufferedWriter and FileWriter)
        ObjectMapper objectMapper1 = new ObjectMapper();
        //configure Object mapper for pretty print
        objectMapper1.configure(SerializationFeature.INDENT_OUTPUT, true);
        try {
            log.info("Started #1");
            String jsonString = objectMapper1.writeValueAsString(createPerson());
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output-person1.json"));
            bufferedWriter.write(jsonString);
            bufferedWriter.close();
            log.info("Finish #1");
        } catch (IOException e) {
            log.severe("Problems occur with #1");
            e.printStackTrace();
        }

        //version#2 (used: FileWriter)
        ObjectMapper objectMapper2 = new ObjectMapper();
        //configure Object mapper for pretty print
        objectMapper2.configure(SerializationFeature.INDENT_OUTPUT, true);
        try {
            log.info("Started #2");
            String jsonString = objectMapper2.writeValueAsString(createPerson());
            FileWriter fileWriter = new FileWriter("output-person2.json");
            fileWriter.write(jsonString);
            fileWriter.close();
            log.info("Finish #2");
        } catch (IOException e) {
            log.severe("Problems occur with #2");
            e.printStackTrace();
        }

        //version#3 (use: File)
        ObjectMapper objectMapper3 = new ObjectMapper();
        //configure Object mapper for pretty print
        objectMapper3.configure(SerializationFeature.INDENT_OUTPUT, true);
        try {
            log.info("Started #3");
            objectMapper3.writeValue(new File("output-person3.json"), createPerson());
            log.info("Finish #3");
        } catch (IOException e) {
            log.severe("Problems occur with #3");
            e.printStackTrace();
        }

    }

    private static Person createPerson() {

        Person person = new Person();
        person.setId(100);
        person.setName("David");
        person.setHeight(175.5);
        person.setClient(true);

        Address add = new Address();
        add.setCity("London");
        add.setStreet("Baker str");
        add.setZipcode(221);
        person.setAddress(add);

        return person;
    }

}
