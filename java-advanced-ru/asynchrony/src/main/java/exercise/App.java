package exercise;

import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;

class App {

    // BEGIN
    public static  CompletableFuture<String> unionFiles(String file1, String file2, String dest) {
        CompletableFuture<String> data1 = CompletableFuture.supplyAsync(() -> {
            String dataFromFile1 = "";
            try {
                Path filePath1 = Paths.get(file1);
                dataFromFile1 = Files.readString(filePath1);
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
            return dataFromFile1;
        });
        CompletableFuture<String> data2 = CompletableFuture.supplyAsync(() -> {
            String dataFromFile2 = "";
            try {
                Path filePath2 = Paths.get(file2);
                dataFromFile2 = Files.readString(filePath2);
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
            return dataFromFile2;
        });

        CompletableFuture<String> dataSum = data1.thenCombine(data2, (strFirst, strSecond) -> {
            String dataFull = strFirst + strSecond;

            try {
                var path = Paths.get(dest).toAbsolutePath().normalize();
                Files.writeString(path, dataFull, StandardOpenOption.CREATE);
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
            return dataFull;

            // Обработка исключений
            // Если при работе задач возникли исключения
            // их можно обработать в методе exceptionally
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return null;
        });
        return dataSum;
    }

/*    public static CompletableFuture<Long> getDirectorySize(String path) {
        var pathDir = Paths.get(path).toAbsolutePath().normalize();
    }
    // END*/

    public static void main(String[] args) throws Exception {
        // BEGIN
        
        // END
    }
}

