public abstract class KeywordAnalizer implements TextAnalizer{
    String[] triggerWords;
    String type;

    public Label processText(String text) {
        boolean flag = false;
        for (int i = 0; i < triggerWords.length; i++) {
            if (text.contains(triggerWords[i])) {
                flag = true;
            }
        }
        if (flag) {
            return new Label(this.type);
        } else {
            return new Label();
        }
    }
}
