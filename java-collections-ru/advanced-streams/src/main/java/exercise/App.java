package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App {
    public static String getForwardedVariables(String content) {
        String[] arrString = content.split("\n");
        String[] arrStream = Arrays.stream(arrString)
                .filter(x -> x.startsWith("environment"))
                .map(strFix -> strFix.trim().substring(13, strFix.length() - 1))
                .map(y -> y.split(","))
                .flatMap(e -> Arrays.stream(e))
                .filter(a -> a.startsWith("X_FORWARDED_"))
                .map(rep -> rep.replaceAll("X_FORWARDED_", ""))
                .toArray(size -> new String[size]);
        Arrays.stream(arrStream).forEach(System.out::println);
        return String.join(",", arrStream);
    }


}
//END
