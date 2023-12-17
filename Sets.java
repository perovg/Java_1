import java.util.HashSet;
import java.util.Set;

public class Sets {
    public static void main(String[] args) {
        HashSet<Integer> a = new HashSet<>();
        HashSet<Integer> b = new HashSet<>();
        a.add(1);
        a.add(2);
        b.add(2);
        b.add(3);
        //union
        System.out.println(union(a, b));
        //interstation
        System.out.println(intersection(a, b));
        //difference
        System.out.println(difference(a, b));
        //symmetricDifference
        System.out.println(symmetricDifference(a, b));
    }
    public static <E> Set<E> intersection(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> s = new HashSet<>(s1);
        s.retainAll(s2);
        return s;
    }

    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> s11 = new HashSet<>(s1);
        Set<E> s12 = new HashSet<>(s2);
        s11.addAll(s12);
        return s11;
    }

    public static <E> Set<E> difference(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> s11 = new HashSet<>(s1);
        Set<E> s12 = new HashSet<>(s2);
        s11.removeAll(s12);
        return s11;
    }
      
    public static <E> Set<E> symmetricDifference(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> s11 = new HashSet<>(s1);
        Set<E> s12 = new HashSet<>(s2);
        return difference(union(s11, s12), intersection(s1, s2));
    }
}
