import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;



public class Driver {
    public static void main(String... args) throws IOException {
        List<String> words = Files.lines(Paths.get("enable1.txt"))
                .filter(x -> x.charAt(0) == 'a')
                .collect(Collectors.toList());
        words
                .forEach(System.out::println);


    }
}
