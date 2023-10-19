public class TooLongTextAnalizer {
    int len;

    public TooLongTextAnalizer(int len) {
        this.len = len;
    }

    public Label processText(String text) {
        if (text.length() <= this.len) {
            return new Label();
        } else {
            return new Label("TooLong");
        }
    }
}
