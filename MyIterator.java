import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIterator<T> implements Iterator<T> {

  public Node<T> curNode;
  
  public MyIterator(Node<T> head) {
    this.curNode = head;
  }


  @Override
  public boolean hasNext() {
    return curNode != null && curNode.next != null;
  }

  @Override
  public T next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }

    T value = curNode.element;
    curNode = curNode.next;
    return value;
  }

  public boolean hasPrevious() {
    return curNode != null && curNode.prev != null;
  }

  public T previous() {
    if (!hasPrevious()) {
      throw new NoSuchElementException();
    }

    T value = curNode.element;
    curNode = curNode.prev;
    return value;
  }
}