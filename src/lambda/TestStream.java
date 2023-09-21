package lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {
    public static void main(String[] args) {
        List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");

        // get the Stream from a source collection
        Stream<String> stream = strings.stream();

        Stream<String> limit = stream.limit(4);


        // Stream methods that return another Stream are called Intermediate Operations. 
        // @return limit = java.util.stream.SliceOps$1@7e9e5f8a
        System.out.println("limit = " + limit);

        // output the result with a terminal operation
        List<String> result = limit.collect(Collectors.toList());

        System.out.println("result = " + result);


        //

        Runnable runnable = ()-> System.out.println("hello");
        Consumer<String> consumer = str->System.out.println(str);
        consumer.accept("hello World");
    }

}
