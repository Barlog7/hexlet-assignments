package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// BEGIN
@Value
@AllArgsConstructor
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    //@SneakyThrows
    public String serialize() {
        ObjectMapper objectMapper = new ObjectMapper();
        String carToJson = null;
        try {
            carToJson = objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e + "2");
        }
        return  carToJson;
    }
    //@SneakyThrows
    public static Car unserialize(String textJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(textJson, Car.class);
        } catch (IOException e) {
            throw new RuntimeException(e + "1");
        }
    }
    // END
}
