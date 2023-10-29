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
        Turple<Integer> turple = new Turple<>(5);
        turple.add(8);
        turple.add(9, 1);
        System.out.println(turple.get(1));
        turple.remove(1);
        System.out.println(turple.orElse(1, 0));

    }
}
