import java.util.List;
import java.util.Optional;
import java.util.function.*;

public class TransformListType {
    public static void main(String[] args) {
        List<String> words = List.of("Как", "же", "я", "устал", "делать", "домашку", "по", "Java");

        Predicate<String> predicate = word -> word.length() > 2;
        Function<String, Integer> mapper = String::length;
        BinaryOperator<Integer> operator = Integer::sum;

        Optional<Integer> result = processElements(words, predicate, mapper, operator);
        result.ifPresent(System.out::println);
    }

    public static <T, R> Optional<R> processElements(List<T> elements, Predicate<T> predicate, Function<T, R> mapper, BinaryOperator<R> operator) {
        return elements.stream()
                .filter(predicate)
                .map(mapper)
                .reduce(operator);
    }
}
