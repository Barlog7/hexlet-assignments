package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static void main(String[] args) {
        App.scrabble("rkqodlw", "world"); // true
        App.scrabble("ajv", "java"); // false
        App.scrabble("avjafff", "JaVa"); // true
        App.scrabble("", "hexlet"); // false


    }
    public static boolean scrabble(String letters, String word) {
        if (word.length() > letters.length()) {
            return false;
        }
        String[] strSplitLetters = letters.split("");
        //List<String> listLetters = Arrays.asList(strSplitLetters);
        List<String> listLetters = new ArrayList<String>(Arrays.asList(strSplitLetters));
        String[] strSplitWord = word.split("");
        //List<String> listWord = Arrays.asList(strSplitWord);
        List<String> listWord = new ArrayList<String>(Arrays.asList(strSplitWord));


        return isBildWord(listLetters, listWord);
    }
    public static boolean isBildWord(List<String> listLetters, List<String> listWord) {
        for (int i = 0; i < listWord.size(); i++) {
            String leterWord = listWord.get(i).toLowerCase();
            boolean find = listLetters.contains(leterWord);
            if (!find) {
                return false;
            }
            listLetters.remove(leterWord);

        }
        return true;
    }
}
//END
