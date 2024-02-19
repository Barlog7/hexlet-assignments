package exercise;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void advancedValidate() {
        var expected3 = Map.of("country", List.of("length less than 4"), "street", List.of("can not be null"));
        Address address = new Address("USA", "Texas", null, "7", "2");
        Map<String, List<String>> result3 = Validator.advancedValidate(address);
        System.out.println(result3);
        assertThat(result3).isEqualTo(expected3);
    }
}