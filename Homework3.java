//import java.util.Arrays;

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
        
    }
}
