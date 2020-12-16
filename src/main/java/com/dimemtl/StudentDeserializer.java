package com.dimemtl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentDeserializer extends StdDeserializer<Student> {

    public StudentDeserializer(){
        super(Student.class);
    }

    @Override
    public Student deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode root = jsonParser.getCodec().readTree(jsonParser);
        JsonNode fNameNode = root.get("firstName");
        String fName = fNameNode.asText();
        String lastName = root.get("lastName").asText();
        String bDayString = root.get("birthday").asText();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        LocalDate bDay = LocalDate.parse(bDayString, f);
        return new Student(fName, lastName, bDay);
    }

}
