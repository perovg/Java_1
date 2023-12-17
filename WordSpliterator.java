import java.util.Spliterator;
import java.util.function.Consumer;

public class WordSpliterator implements Spliterator<String> {
    private final String text;
    private int current;
    public WordSpliterator(String text) {
        this.text = text;
    }
    @Override
    public boolean tryAdvance(Consumer<? super String> action) {
        if (current >= text.length()) {
            return false;
        }
  
        int start = current;
        while (current < text.length() && text.charAt(current) != ' ') {
            current++;
        }
        String word = text.substring(start, current);
        action.accept(word);

        while (current < text.length() && text.charAt(current) == ' ') {
            current++;
        }
  
        return current != start;
    }

    @Override
    public Spliterator<String> trySplit() {
        int size = text.length() - current;
        if (size < 10) {
            return null;
        }
  
        int splitPos = current + size / 2;
        while (splitPos < text.length() && text.charAt(splitPos) != ' ') {
            splitPos++;
        }
  
        if (splitPos == text.length()) {
            return null;
        }
  
        WordSpliterator newSpliterator = new WordSpliterator(text.substring(current, splitPos));
        current = splitPos + 1;
  
        return newSpliterator;
    }

    @Override
    public long estimateSize() {
        return text.length() - current;
    }

    @Override
    public int characteristics() {
        return ORDERED | SIZED | SUBSIZED | NONNULL | IMMUTABLE;
    }
}
