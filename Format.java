import java.util.function.*;

public class Format {
    public static void main(String[] args) {
        Function<String, String> sayHello = saySmth("Hello");
        System.out.println(sayHello.apply("Alice"));
    }
    
    static <A, B, C> Function<A, Function<B, C>> curry(BiFunction<A, B, C> fn) {
        return a -> b -> fn.apply(a, b);
    }

    static Function<String, String> saySmth(String word) {
        return curry((String greeting, String name) -> greeting + ", " + name + "!").apply(word);
    }
}