package exercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReversedSequenceTest {
    @Test
    void testReversedSequence() {
        String text = "abcdef";
        var revStr = new ReversedSequence(text);
        String expected = "fedcba";
        int lengthExp = 6;
        char charExp = 'e';
        String substringExp = "edc";

        String result = revStr.toString();
        assertThat(result).isEqualTo(expected);

        int resultLength = revStr.length();
        assertThat(resultLength).isEqualTo(lengthExp);

        char charRez = revStr.charAt(1);
        assertThat(charRez).isEqualTo(charExp);

        String rezSubstring = revStr.subSequence(1, 4).toString();
        assertThat(rezSubstring).isEqualTo("edc");
    }

}