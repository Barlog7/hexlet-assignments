package exercise;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;

class App {

    // BEGIN
    private static Path getFullPath(String path) {
        return Paths.get(path).toAbsolutePath().normalize();
    }

    public static  CompletableFuture<String> unionFiles(String file1, String file2, String dest) {
        CompletableFuture<String> data1 = CompletableFuture.supplyAsync(() -> {
            String dataFromFile1 = "";
            try {
                Path filePath1 = getFullPath(file1);
                dataFromFile1 = Files.readString(filePath1);
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
            return dataFromFile1;
        });
        CompletableFuture<String> data2 = CompletableFuture.supplyAsync(() -> {
            String dataFromFile2 = "";
            try {
                //Path filePath2 = Paths.get(file2);
                Path filePath2 = getFullPath(file2);
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

    public static Long getDirectorySize(String path) {


/*        var directory = new File(path);

        if (!directory.isDirectory()) {
            return CompletableFuture.completedFuture(0L);
        }*/

        var dir = new File(path);
        File[] files = dir.listFiles();

/*        for (File file : files) {
            if (file.isFile()) {
                //System.out.println(file.getName());
            }
        }*/
        List<File> filesOnly = Arrays.stream(files).filter(v -> v.isFile()).toList();

        Integer fileSizes = filesOnly.stream().map(f -> CompletableFuture.supplyAsync(() -> f.length())).map(v -> v.join()).mapToInt(a -> a.intValue()).sum();

/*        CompletableFuture<Long>[] fileSizes = Arrays.stream(files)
                .filter(File::isFile)
                .map(file -> CompletableFuture.supplyAsync(() -> file.length()))
                .toArray(CompletableFuture[]::new);

        return CompletableFuture.allOf(fileSizes)
                .thenApply(v -> Arrays.stream(fileSizes)
                        .mapToLong(CompletableFuture::join)
                        .sum());*/


        return fileSizes.longValue();
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        CompletableFuture<String> result = unionFiles(
                "src/main/resources/file1.txt",
                "src/main/resources/file2.txt",
                "src/main/resources/dest.txt"
        );
        // END
    }
}

