import java.util.Arrays;
public class Test {
    public static String checkLabels(String text, String ... classes) {
        String type = "Ok";
        System.out.println(Arrays.toString(classes));
        for (int i = 0; i < classes.length; i++) {
            if (classes[i] == "SpamAnalizer") {
                SpamAnalizer spamAnalizer = new SpamAnalizer();
                Label label = spamAnalizer.processText(text);
                type = label.type;
                if (type != "Ok") {
                    break;
                }
            } else if (classes[i] == "TooLongTextAnalizer") {
                TooLongTextAnalizer tooLongTextAnalizer = new TooLongTextAnalizer(100);
                Label label = tooLongTextAnalizer.processText(text);
                type = label.type;
                if (type != "Ok") {
                    break;
                }
            } else if (classes[i] == "NegativeAnalizer") {
                NegativeAnalizer negativeAnalizer = new NegativeAnalizer();
                Label label = negativeAnalizer.processText(text);
                type = label.type;
                if (type != "Ok") {
                    break;
                }
            }
        }
        return type;
    }
}
