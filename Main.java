import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Task 1
        /*MyLinkedList<Integer> linkedList = new MyLinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(1, 5);
        linkedList.printList();
        linkedList.remove(2);
        System.out.println(linkedList.get(2));*/
        //Task 2
        /*MyDeque<Integer> deque = new MyDeque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.printDeque();
        System.out.println(deque.removeFirst());
        deque.printDeque();*/
        //Task 3
        /*List<Integer> list = ListUtil.rangeList(3, 6);
        System.out.println(list.indexOf(4));
        System.out.println(list.contains(5));*/
        //Task 4
        /*ArrayList<String> states1 = new ArrayList<String>();
        states1.add("Germany");
        states1.add("France");
        ArrayList<String> states2 = new ArrayList<String>();
        states2.add("Italy");
        states2.add("Spain");
         
        Iterator<String> first = states1.iterator();
        Iterator<String> second = states2.iterator();
        DoubleIterator<String> iter = new DoubleIterator<>(first, second);
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }*/
        //Task 5
        /*List<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.add(8);
        a.add(7);
        a.add(3);
        a.add(9);
        a.add(1);
        List<Integer> list = ListUtil2.medianSort(a);
        System.out.println(list);*/
    }
}
