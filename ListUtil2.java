import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListUtil2 {
    public static List<Integer> medianSort(List<Integer> myList) {
        if (myList.size() <= 1) {
            return myList;
        }
        int median = findMedian(myList);
        Comparator<Integer> myComparator = new MediansComparator(median);
        Collections.sort(myList, myComparator);
        return myList;
    }
    
    public static int findMedian(List<Integer> list) {
        Collections.sort(list);
        if (list.size() % 2 != 0) {
            return list.get(list.size() / 2);
        } else {
            return (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2 + (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) % 2;
        }
    }
}

class MediansComparator implements Comparator<Integer> {

    public int m;

    public MediansComparator(int m) {
        this.m = m;
    }

    @Override
    public int compare(Integer a, Integer b) {
        if (Math.abs(m - a) > Math.abs(m - b)) {
            return 1;
        } else if (Math.abs(m - a) < Math.abs(m - b))  {
            return -1;
        } else {
            return 0;
        }
    }
}