package exercise;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
class AppTest {
    @Test
    void testenlargeArrayImage() {
        String[][] image = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };
        String[][] enlargedImage = App.enlargeArrayImage(image);
        String expected = "[[*, *, *, *, *, *, *, *], [*, *, *, *, *, *, *, *], [*, *,  ,  ,  ,  , *, *], [*, *,  ,  ,  ,  , *, *], [*, *,  ,  ,  ,  , *, *], [*, *,  ,  ,  ,  , *, *], [*, *, *, *, *, *, *, *], [*, *, *, *, *, *, *, *]]";
        String actual = Arrays.deepToString(enlargedImage);
        assertThat(actual).isEqualTo(expected);
        //System.out.println(Arrays.deepToString(enlargedImage));
    }

    @Test
    void testenlargeArrayImageNull() {
        String[][] image = {};
        String[][] enlargedImage = App.enlargeArrayImage(image);
        //String expected = null;
        //String actual = Arrays.deepToString(enlargedImage);
        assertThat(enlargedImage).isEqualTo(null);
        //System.out.println(Arrays.deepToString(enlargedImage));
    }
}
// END
