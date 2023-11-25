import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

public class Swap {
    public static void main(String[] args) {
        HashMap<Integer, String> passportsAndNames = new HashMap<>();
        passportsAndNames.put(1, "Лидия Аркадьевна Бубликова");
        passportsAndNames.put(2, "Иван Михайлович Серебряков");
        passportsAndNames.put(3, "Дональд Джон Трамп");
        passportsAndNames.put(4, "Дональд Джон Трамп");
        Map<String, Collection<Integer>> swapped = inverse(passportsAndNames);
        for (Map.Entry<String, Collection<Integer>> entry : swapped.entrySet()) {
            String key = entry.getKey();
            Collection<Integer> value = entry.getValue();
            System.out.println("Key: " + key + "  Value: " + value.toString());
        }
    }
    public static <K, V, T extends K, E extends V> Map<V, Collection<K>> inverse(Map<T, E> map){
        Map<V, Collection<K>> res = new HashMap<>();
        for (Map.Entry<T, E> entry : map.entrySet()) {
            T value = entry.getKey();
            E key = entry.getValue();
            if (res.containsKey(key)) {
                res.get(key).add(value);
            } else {
                Collection<K> list = new ArrayList<>();
                list.add(value);
                res.put(key, list);
            }
        }
        return res;
    }
}
