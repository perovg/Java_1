import java.util.function.BiFunction;
import java.util.function.Function;

public class MultiplicationByTwo {
    static <A, B, C> Function<B, C> bind(BiFunction<A, B, C> fn, A a) {
        return b -> fn.apply(a, b);
    } 
    public static void main(String[] args) {
        Function<Integer, Integer> inc = bind(Integer::sum, 1);
        System.out.println("inc: " + inc.apply(10) + "\n");
    }

    
}
