import java.util.AbstractList;
import java.util.List;

public class ListUtil {

    public static List<Integer> rangeList(int first, int last) {
        return new AbstractList<>() {
            
            @Override
            public Integer get(int idx) {
                if (idx < 0 || idx > last - first - 1) {
                    throw new IndexOutOfBoundsException();
                }
                return first + idx;
            }

            @Override
            public int size() {
                return last - first;
            }

            @Override
            public int indexOf(Object o) {
                for (int i = first; i < last; i++) {
                    if ((int) o == i) {
                        return i - first;
                    }
                }
                return -1;
            }

            @Override
            public int lastIndexOf(Object o) {
                for (int i = last - 1; i >= first; i--) {
                    if ((int) o == i) {
                        return i - first;
                    }
                }
                return -1;
            }

            @Override
            public boolean contains(Object o) {
                return indexOf(o) != -1;
            }
        };
    }
}