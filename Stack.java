public interface Stack<E> {

  void push(E el);

  E pop();

  E peek();

  int size();

  boolean isEmpty();
}