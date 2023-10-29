public class Homework4 {
    public static void main(String[] args) {
        //Task 1
        /*MatrixClass<String> matrix = new MatrixClass<String>(new String[2][3]);
        matrix.append("Грузия", 0, 2);
        System.out.println(matrix.get(0, 2));
        matrix.delete(0, 2);
        System.out.println(matrix.get(0, 2));
        MatrixClass<String> matrix1 = new MatrixClass<String>(2, 3);
        matrix1.append("США", 1, 1);
        System.out.println(matrix1.get(1, 1));*/
        //Task 2
        /*Turple<Integer> turple = new Turple<>(5);
        turple.add(8);
        turple.add(9, 1);
        System.out.println(turple.get(1));
        turple.remove(1);
        System.out.println(turple.orElse(1, 0));*/
        //Task 3
        /*Pair<Integer> pair = new Pair<Integer>(6, 3);
        System.out.println(pair.getLeft());
        System.out.println(pair.getRight());
        System.out.println(pair.max());
        System.out.println(pair.min());*/
        //Task 4
        Integer[] a = {4, 15, 8, 11, 3, 7, 21};
        Pair<Integer> pair = minMax(a);
        System.out.println(pair.min());
        System.out.println(pair.max());
        System.out.println(pair.getLeft());
        System.out.println(pair.getRight());
    }

    public static <T extends Comparable<T>> Pair<T> minMax(T[] a) {
        if (a.length == 0) {
            return null;
        } else {
            T min = a[0];
            T max = a[0];
            for (T el : a) {
                if (el.compareTo(min) < 0) {
                    min = el;
                }
                if (el.compareTo(max) > 0) {
                    max = el;
                }
            }
            return new Pair<>(min, max);
        }
    }
}
