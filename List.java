public interface List<E> {

  void add(E el);

  void add(int index, E el);

  void remove(int index);

  E get(int index);

  boolean isEmpty();

  int size();
}