package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
class App {
    //@SneakyThrows
    public static void save(Path path, Car car) {
        String textJson = car.serialize();
        //ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.writeValue(new File(path.toString()), car);
        try {
            Files.writeString(path, textJson, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    //@SneakyThrows
    public static Car extract(Path path) {
        String content = null;
        try {
            content = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = null;
        try {
            car = objectMapper.readValue(content, Car.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return car;
    }
}
// END
