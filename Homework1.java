import java.lang.Math;
import java.math.BigInteger;
//import java.util.Arrays;

public class Homework1 {
    public static void main(String[] args) {
        //convert(74);
        //System.out.println(Integer.toString(normalize(-30)));
        //System.out.println(Integer.toString(max(3, 6, 2)));
        //System.out.println(fact(4));
        //BigInteger forTask5 = new BigInteger("3"); // переменная для тестирования Task5()
        //System.out.println(factForBigInteger(forTask5));
        //multiplTable();
        //System.out.println(Double.toString(average(5, 6, 7, 8)));
        //System.out.println(isMagicSquare(new int[][]{{16, 3, 2, 13}, {5, 10, 11, 8}, {9, 6, 7, 12}, {4, 15, 14, 1}}));
        //System.out.println(Arrays.toString(reverse(new int[]{1, 2, 3})));
        //System.out.println(Arrays.toString(sort(new int[]{3, 1, 2, -1, -5})));
        //System.out.println(Arrays.toString(removeExtra(new int[]{2, 1, 45, 2, 34, 1, 12, 2}, 2)));
    }
    //Task1 
    public static String translate(int x, int y) {
        String[] z = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        String count = "";
        while(x > 0) {
            count = z[x % y] + count;
            x = x / y;
        }
        return count;
    }
    public static void convert(int x) {
        System.out.println(translate(x, 2));
        System.out.println(translate(x, 8));
        System.out.println(translate(x, 16));
    }
    //Task2
    public static int normalize(int x) {
        return Math.floorMod(x, 360);
    }
    //Task3
    public static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
    //Task4
    public static int fact(int x) {
        if (x > 1) {
            return x * fact(x - 1);
        }
        return 1;
    }
    //Task5
    public static BigInteger factForBigInteger(BigInteger x) {
        int z = x.compareTo(BigInteger.ONE);
        if (z == 1) {
            BigInteger a = x.subtract(BigInteger.ONE);
            return x.multiply(factForBigInteger(a));
        }
        return BigInteger.ONE;
    }
    //Task6
    public static void multiplTable() {
        for (int x = 1; x < 10; x++){
            for (int y = 1; y < 10; y++) {
                String x1 = Integer.toString(x);
                String y1 = Integer.toString(y);
                System.out.println(x1 + " * " + y1 + " = " + Integer.toString(x * y));
            }
            System.out.println();
        }
    }
    //Task7
    public static double average(int ... array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        return sum * 1.0 / array.length;
    }
    // Task 8
    static boolean isMagicSquare(int[][] square) {
        int x = square.length;
        int[] array = new int[x * 2 + 2];
        for (int i = 0; i < x; i++){
            int sum = 0;
            for (int j = 0; j < x; j++) {
                sum += square[i][j];
            }
            array[i] = sum;
        }
        for (int i = 0; i < x; i++) {
            int sum = 0;
            for (int j = 0; j < x; j++) {
                sum += square[j][i];
            }
            array[i + x] = sum;
        }
        for (int i = 0; i < x; i++) {
            array[2 * x] += square[i][i];
        }
        for (int i = 0; i < x; i++) {
            array[2 * x + 1] += square[x - 1 - i][i];
        }
        int flag = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1]) {
                flag = 0;
                break;
            }
        }
        if (flag == 1) {
            return true;
        }
        return false;
    }


    // Task 9
    static int[] reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return arr;
    }


    // Task 10
    static int[] sort(int[] arr) {
        int len = arr.length;
        int[] sorted = new int[len];
        int maxim = arr[0];
        for (int i = 0; i < len; i++) {
            if (maxim < arr[i]) {
                maxim = arr[i];
            }
        }
        for (int i = 0; i < len; i++) {
            int min = arr[0];
            int index = 0;
            for (int j = 0; j < len; j++) {
                if (arr[j] < min){
                    min = arr[j];
                    index = j;
                }
            }
            arr[index] = maxim;
            sorted[i] = min;
        }
        return sorted;
    }


    // Task 11
    static int[] removeExtra(int[] arr, int n) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == n){
                cnt += 1;
            }
        }
        int[] pop = new int[arr.length - cnt];
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if(arr[j] != n){
                pop[i] = arr[j];
                i += 1;
            }
        }
        return pop;
    }
}