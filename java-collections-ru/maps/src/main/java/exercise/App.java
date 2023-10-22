package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static void main(String[] args) {
        //String str = "the java is the best programming language java";
        String str = "";
        Map<String, Integer> words = getWordCount(str);
        String s = toString(words);
        System.out.println(s);
    }
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> words = new HashMap<>();
        if (sentence.length() == 0) {
            return words;
        }
        String[] strSplitWords = sentence.split(" ");
        for (String word : strSplitWords) {
            int  colWord = words.get(word) == null ? 0 : words.get(word);
            words.put(word, colWord + 1);
        }
        return words;
    }
    public static String toString(Map<String, Integer> map) {
        if (map.size() == 0) {
            return "{}";
        }
        StringBuilder bulder = new StringBuilder();
        bulder.append("{\n");
        for (String s : map.keySet()) {
            int countWord = map.get(s);
            bulder.append("  " + s + ": " + countWord + "\n");
        }
        bulder.append("}");
        return bulder.toString();
    }

}
//END
