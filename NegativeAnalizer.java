public class NegativeAnalizer extends KeywordAnalizer {
    public NegativeAnalizer() {
        this.type = "Negative";
        this.triggerWords = new String[] {":|)", ":(", "=("};
    }
}
