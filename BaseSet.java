public interface BaseSet<E> extends Iterable<E> {

  void add(E e);

  void remove(Object o);

  boolean contains(Object o);

  boolean equals(Object o);

  boolean isEmpty();

  int size();

  void clear();
}