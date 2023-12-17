import java.util.function.*;

public class Substring {
    public static void main(String[] args) {
        BiFunction<String, Integer, String> substring = (str, endIndex) -> str.substring(0, endIndex);
        String str = "Барабудайбарабирабудай";
        int endIndex = 5;

        Function<Integer, String> takeSubstring = bind(substring, str);
        String result = takeSubstring.apply(endIndex);

        System.out.println(result);
    }
    
    static <A, B, C> Function<B, C> bind(BiFunction<A, B, C> fn, A a) {
        return b -> fn.apply(a, b);
    }
}