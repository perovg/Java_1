//import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework3 {
    public static void main(String[] args) {
        //Task 1
        /*IntSequence sequence = IntSequence.of(1, 2, 3, 4);
        for (int i = 0; i < 5; i ++) {
            System.out.println(Integer.toString(sequence.next()));
        }*/
        /*IntSequence constant = IntSequence.constant(3);
        for (int i = 0; i < 4; i++) {
            System.out.println(Integer.toString(constant.next()));
        }*/
        // Task 2
        /*String text = "Sports betting! Big wins! Register";
        SpamAnalizer spamAnalizer = new SpamAnalizer("wins", "rates", "bettings", "casino");
        Label label = spamAnalizer.processText(text);
        System.out.println(label.type);*/
        /*String text = "You are bad person! =(";
        NegativeAnalize negativeAnalize = new NegativeAnalize();
        Label label = negativeAnalize.processText(text);
        System.out.println(label.type);*/
        /*String text = "Very very long text";
        TooLongTextAnalizer tooLongTextAnalizer = new TooLongTextAnalizer(15);
        Label label = tooLongTextAnalizer.processText(text);
        System.out.println(label.type);*/
        /*String text = "You are very bad person :(. You not want to win some dollars!";
        System.out.println(Test.checkLabels(text, "TooLongTextAnalizer", "NegativeAnalizer", "SpamAnalizer"));*/
        //Task 3
        /*Printable printer;
        printer = (x, y) -> System.out.printf("В том бою, в русской армии было %s солдат и %s орудий", x, y);
        
        printer.print(6500, 56);*/
        //Task 4
        /*Signum signum = x -> {
            if (x > 0) {
                System.out.println("Положительное число");
            }
            if (x == 0) {
                System.out.println("Ноль");
            }
            if (x < 0) {
                System.out.println("Отрицательное число");
            }
        };
        signum.sign(-5);
        signum.sign(0);
        signum.sign(5);*/
        //Task 5
        /*String login = "Grigory Perov";
        String password = "Student_of_MIPT2023";
        String confirmPassword = "Student_of_MIPT2023";
        System.out.println(Homework3.registration(login, password, confirmPassword));*/
        //Task 6
        //Смотри Check 1
        //Task 7
        try {
            int a = 42 / 0;
        } catch(ArithmeticException e) {
            System.out.println("Divizion by zero");
        }
    }

    public static boolean registration(String login, String password, String confirmPassword) {
        try {
            if (login.length() >= 20) {
                throw new WrongLoginException();
            }
            String regex = "^[a-zA-Z0-9_]+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(password);
            if (password.length() >= 20 || matcher.matches() == false || password.equals(confirmPassword) == false) {
                throw new WrongPasswordException();
            }
        } catch(WrongLoginException e) {
            return false;
        } catch(WrongPasswordException e) {
            return false;
        }
        return true;
    };
}

