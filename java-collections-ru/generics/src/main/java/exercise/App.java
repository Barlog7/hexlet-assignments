package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> serchParam) {
        List<Map<String, String>> resultBooks = new ArrayList<>();
        for (var book : books) {
            boolean bFind = serchBook(book, serchParam);
            if (bFind) {
                resultBooks.add(book);
            }
        }

        return resultBooks;
    }
    public static boolean serchBook(Map<String, String> book, Map<String, String> serchParam) {
        for (Map.Entry<String, String> param: serchParam.entrySet()) {
            String sValueBook = book.getOrDefault(param.getKey(), "not find book");
            String sValueParam = param.getValue();
            if (!sValueParam.equals(sValueBook)) {
                return false;
            }
        }
        return true;
    }
}
//END
