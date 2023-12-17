import java.util.function.*;;

public class MultiplicationByTwo {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        int a = 2;
        Function<Integer, Integer> multiplyBy2 = bind(multiply, a);
        int result = multiplyBy2.apply(3);
        System.out.println(result);
    }
    
    static <A, B, C> Function<B, C> bind(BiFunction<A, B, C> fn, A a) {
        return b -> fn.apply(a, b);
    }
}
