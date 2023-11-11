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
        List<Integer> list = ListUtil.rangeList(3, 6);
        System.out.println(list.indexOf(4));
        System.out.println(list.contains(5));
    }
}
