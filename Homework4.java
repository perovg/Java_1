public class Homework4 {
    public static void main(String[] args) {
        //Task 1
        MatrixClass<String> matrix = new MatrixClass<String>(new String[2][3]);
        matrix.append("Грузия", 0, 2);
        System.out.println(matrix.get(0, 2));
        matrix.delete(0, 2);
        System.out.println(matrix.get(0, 2));
        MatrixClass<String> matrix1 = new MatrixClass<String>(2, 3);
        matrix1.append("США", 1, 1);
        System.out.println(matrix1.get(1, 1));
    }
}
