import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class Eratosphen {
    public static void main(String[] args) {
        System.out.println("Введите число не меньшее 2:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> x = Eratosphen.findPrimes(n);
        Iterator<Integer> iterator = x.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        sc.close();
    }

    public static List<Integer> findPrimes(int n) {
        HashSet<Integer> numbers = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            numbers.add(i);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (numbers.contains(i)) {
                res.add(i);
                for(int j = 2 * i; j <= n; j += i) {
                    numbers.remove(j);
                }
            }
        }
        return res;
    }
}