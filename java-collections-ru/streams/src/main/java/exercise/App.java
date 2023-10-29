package exercise;

import java.util.List;
//import java.util.Arrays;

// BEGIN
class App {
    public static int getCountOfFreeEmails(List<String> emailsList) {
        //int count = emailsList.stream().filter(name -> StringUtils.isNotBlank(name))
        if (emailsList.isEmpty()) {
            return 0;
        }
        int count = (int) emailsList.stream()
                .filter(name -> name.endsWith("gmail.com")
                        || name.endsWith("yandex.ru")
                        || name.endsWith("hotmail.com"))
                .count();
        return count;
    }
}
// END
