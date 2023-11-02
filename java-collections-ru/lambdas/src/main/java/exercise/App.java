package exercise;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
   /* public static String[][] enlargeArrayImage(String[][] image) {
        if (image.length == 0) {
            return null;
        }
        int firstSize = image.length * 2;
        int secondSize = image[0].length * 2;
        String[][] largeArr = new String[firstSize][secondSize];
        int stepY = 0;
        for (int i = 0; i < image.length; i++) {
            int stepX = 0;
            for (int j = 0; j < image[i].length; j++) {
                largeArr[i + stepY][j + stepX] = image[i][j];
                largeArr[i + stepY][j + stepX + 1] = image[i][j];
                largeArr[i + stepY + 1][j + stepX] = image[i][j];
                largeArr[i + stepY + 1][j + stepX + 1] = image[i][j];
                stepX++;
            }
            stepY++;
        }
        return largeArr;
    }*/

    public static String[][] enlargeArrayImage(String[][] image) {
        if (image.length == 0) {
            return null;
        }

/*        List<String[]> coll = Arrays.stream(image)
                .flatMap(item -> Arrays.stream(new String[][] {item, item}))
                .collect(Collectors.toList());*/


        String[][] largeArr = Arrays.stream(image)
                .flatMap(item -> Arrays.stream(new String[][] {makeDouble(item), makeDouble(item)}))
                .toArray(String[][]::new);




      /*  int firstSize = image.length * 2;
        int secondSize = image[0].length * 2;
        String[][] largeArr = new String[firstSize][secondSize];
        int stepY = 0;
        for (int i = 0; i < image.length; i++) {
            int stepX = 0;
            for (int j = 0; j < image[i].length; j++) {
                largeArr[i + stepY][j + stepX] = image[i][j];
                largeArr[i + stepY][j + stepX + 1] = image[i][j];
                largeArr[i + stepY + 1][j + stepX] = image[i][j];
                largeArr[i + stepY + 1][j + stepX + 1] = image[i][j];
                stepX++;
            }
            stepY++;
        }*/
        return largeArr;
    }
    public static String[] makeDouble(String[] str) {
        int firstSize = str.length * 2;
        String[] strNew = new String[firstSize];
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            strNew[count] = str[i];
            strNew[count + 1] = str[i];
            count = count + 2;
        }
        return strNew;
    }

    /*public static void main(String[] args) {
        *//*String[][] image = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };*//*
        *//*String[][] image = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };*//*
        String[][] image = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"},
        };
        String[][] enlargedImage = App.enlargeArrayImage(image);
        System.out.println(Arrays.deepToString(enlargedImage));

    }*/
}
// END
