public class SpamAnalizer extends KeywordAnalizer {
    public SpamAnalizer(String ... v) {
        this.type = "Spam";
        this.triggerWords = v;
    }

    public SpamAnalizer() {
        this.type = "Spam";
        this.triggerWords = new String[] {"wins", "dollars"};
    }
}
