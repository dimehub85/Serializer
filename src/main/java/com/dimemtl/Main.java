package com.dimemtl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
       /* ObjectMapper om = new ObjectMapper();
        Student s = new Student("John", "Doe", LocalDate.of(2010, 10, 10));
        SimpleModule m = new SimpleModule();
        m.addSerializer(Student.class, new StudentSerializer());
        om.registerModule(m);
        System.out.println(om.writeValueAsString(s));*/

        String json = "{\"firstName\":\"John\",\"lastName\":\"John\",\"birthday\":\"10-окт.-2010\"}";
        ObjectMapper om = new ObjectMapper();
        SimpleModule m = new SimpleModule();
        m.addDeserializer(Student.class, new StudentDeserializer());
//        om.registerModule(new JavaTimeModule());
        om.registerModule(m);
        Student s = om.readValue(json, Student.class);
        System.out.println(s);
    }

}
