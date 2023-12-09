import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Test {
    public static void main(String[] args) {
        String text = "Серые глаза - рассвет, пароходная сирена, дождь, разлука, серый след за винтом бегущей пены";
        WordSpliterator wordSpliterator = new WordSpliterator(text);
        Stream<String> wordStream = StreamSupport.stream(wordSpliterator, false);
        wordStream.forEach(System.out::println);
    }
}