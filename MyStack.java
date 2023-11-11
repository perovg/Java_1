import java.util.Arrays;

public class MyStack<E> implements Stack<E> {

  private Object[] values;
  private static final int CAP = 8;
  private int size;

  public MyStack() {
    values = new Object[CAP];
  }

  @Override
  public void push(E el) {
    if (size == values.length) {
      values = Arrays.copyOf(values, size * 2);
    }
    values[size++] = el;
  }

  @Override
  @SuppressWarnings("unchecked")
  public E peek() {
    return (E) values[size - 1];
  }

  @Override
  @SuppressWarnings("unchecked")
  public E pop() {
    E result = (E) values[--size];
    values[size] = null;
    return result;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public String toString() {
    return "MyStack{values=" + Arrays.toString(values) + '}';
  }
}