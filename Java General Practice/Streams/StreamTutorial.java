import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTutorial {
    /**
     * Source > Filter > Sort > Map > Collect
     * Stream source can be created from colelctions, lists, sets, ints, longs, etc.
     *
     * Stream ops are intermiediate or terminal.
     *
     * Intermediate = filter, map, or sort return a stream so multiple intermediate ops can be chained - should always filter first
     * to compress data
     *
     *
     * Terminal = forEach, collect, or reduce are either void or return non-stream result - only 1 per stream
     *
     *Questions - Benefit to useing :: vs out.print
     *          -
     */

    public static void main(String... args) throws IOException {
        //Int stream
        System.out.print("Int Stream example: ");
        IntStream
                .range(1,10)
                .forEach(System.out::print);
        System.out.println();
        ///////////////////////////////////////////////////////////
        System.out.println("Int Stream example w/ skip and action");
        IntStream
                .range(1,10)
                .skip(5)
                .forEach(x -> System.out.println(x));
        System.out.println();
        ///////////////////////////////////////////////////////////
        System.out.println("Int Stream example w/ print encasement and sum");
        System.out.print(
        IntStream
            .range(1, 5)
            .sum());

        System.out.println("\n");
        ///////////////////////////////////////////////////////////
        System.out.println("Stream.of example w/ sorting");
        Stream.of("Tyler", "Trevor", "Tacitus")
                .sorted()
                .findFirst()
                .ifPresent(System.out::print);
        System.out.println("\n");
        ///////////////////////////////////////////////////////////
        System.out.println("Stream from array and sort/filter/print");
        String[] names = {"Antonius Pius","Trajan","Hadrian","Nerva", "Marcus Aurelius"};
        Arrays.stream(names)
                .filter(x -> x.startsWith("M"))
                .sorted()
                .forEach(System.out::println);
        System.out.println("\n");
        ///////////////////////////////////////////////////////////
        System.out.println("Arrays.stream example w/ .average and .ifPresent");
        Arrays.stream(new int[] {2,4,6,8,10})
                .map(x -> x*x)
                .average()
                .ifPresent(System.out::println);
        System.out.println("\n");
        ////////////////////////////////////////////////////////////
        System.out.println("Arrays.stream example w/ mapping/filter/forEach");
        Arrays.stream(names)
                .map(String::toLowerCase)
                .filter(x->x.startsWith("h"))
                .forEach(System.out::println);
        System.out.println("\n");
        ////////////////////////////////////////////////////////////
        System.out.println("Creating stream object via text file");
        Stream<String> words = Files.lines(Paths.get("enable1.txt"));
        words
                .sorted()
                .filter(x -> x.length() > 25)
                .forEach(System.out::println);
        words.close();
        System.out.println("\n");
        /////////////////////////////////////////////////////////////
        List<String> words2 = Files.lines(Paths.get("enable1.txt"))
                .filter(x -> x.contains("jit"))
                .collect(Collectors.toList());  //Terminates the running stream
        words2.forEach(x -> System.out.println(x)); //Create new stream to print
        System.out.println("\n");
        ////////////////////////////////////////////////////////////
        System.out.println("Dual filter example - reads data from file splits/filterX2/collects.");
        Stream<String> rows = Files.lines(Paths.get("data.txt"));

        Map<String, Integer> map = new HashMap<>();
        map = rows
                .map(x -> x.split(","))
                .filter(x -> x.length == 4)
                .filter(x -> Integer.parseInt(x[1]) > 5)
                .collect(Collectors.toMap(
                        x -> x[0],
                        x->Integer.parseInt(x[1])));
        rows.close();
        for(String key : map.keySet()) System.out.println("key = "+key+ ", value = " + map.get(key));
        ////////////////////////////////////////////////////////////
        System.out.println("Reduction example");
        double total = Stream.of(7.3, 19.4, 124.5)
                .reduce(0.0, (Double a, Double b) -> a+b);
        System.out.println("Total = " + total);
        System.out.println("\n");
        ////////////////////////////////////////////////////////////
        System.out.println("Reduction w/ summary statistics");
        IntSummaryStatistics summary = IntStream.of(7, 9 ,11 ,13, 132, 329)
                .summaryStatistics();
        System.out.println(summary);
    }
}
