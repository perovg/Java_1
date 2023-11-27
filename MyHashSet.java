import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyHashSet<E> implements BaseSet<E> {

  private static final int DEFAULT_CAPACITY = 1 << 4;
  private static final int MAX_CAPACITY = 1 << 30;
  private static final float LOAD_FACTOR = 0.75f;

  private Node<E>[] table;
  private int size;
  private final float loadFactor;
  private int threshold = DEFAULT_CAPACITY;

  private int modCount = 0;

  private static int hash(int h, int length) {
    h ^= (h >>> 20) ^ (h >>> 12);
    h ^= (h >>> 7) ^ (h >>> 4);
    return h & (length - 1);
  }

  @SuppressWarnings("unchecked")
  public MyHashSet(float loadFactor) {
    this.loadFactor = loadFactor;
    Node<E>[] newHashTable = (Node<E>[]) new Node[DEFAULT_CAPACITY];
    table = newHashTable;
    size = 0;
  }

  @SuppressWarnings("unchecked")
  public MyHashSet() {
    this.loadFactor = LOAD_FACTOR;
    Node<E>[] newHashTable = (Node<E>[]) new Node[DEFAULT_CAPACITY];
    table = newHashTable;
    size = 0;
  }

  @SuppressWarnings("unchecked")
  private void resize(int newCapacity) {
    if (table.length == MAX_CAPACITY) {
      threshold = Integer.MAX_VALUE;
    } else {
      Node<E>[] copyOfTable = Arrays.copyOf(table, table.length);
      Node<E>[] newHashTable = (Node<E>[]) new Node[newCapacity];
      table = newHashTable;
      size = 0;
      for (int i = 0; i < copyOfTable.length; i++) {
        if (copyOfTable[i] != null) {
          Node<E> e = copyOfTable[i];
          while (e != null) {
            add(e.key);
            e = e.next;
          }
        }
      }
      threshold = (int) (newCapacity * loadFactor);
    }
  }

  @Override
  public void add(E key) {
    modCount += 1;
    if (size >= this.threshold) {
      resize(2 * table.length);
    }
    if (key == null) {
      if (table[0] == null) {
        Node<E> newE = new Node<>(0, key, null);
        table[0] = newE;
        size++;
      } else {
        Node<E> e = table[0];
        while (e.key != null) {
          if (e.next == null) {
            Node<E> newE = new Node<>(0, key, table[0]);
            table[0] = newE;
            size++;
            return;
          } else {
            e = e.next;
          }
        }
      }
    } else {
      int hashKey = hash(key.hashCode(), table.length);
      if (table[hashKey] == null) {
        Node<E> newE = new Node<>(hashKey, key, null);
        table[hashKey] = newE;
        size++;
      } else {
        Node<E> e = table[hashKey];
        while (e.key == null || !(e.key.equals(key))) {
          if (e.next == null) {
            Node<E> newE = new Node<>(hashKey, key, table[hashKey]);
            table[hashKey] = newE;
            size++;
            return;
          } else {
            e = e.next;
          }
        }
      }
    }
  }

  @Override
  public void remove(Object key) {
    if (key == null) {
      if (table[0] == null) {
        return;
      } else {
        modCount += 1;
        Node<E> tE = table[0];
        if (table[0].key == null) { // if the head of the ll is null
          Node<E> keyToRemove = table[0];
          table[0] = keyToRemove.next;
          size--;
          return;
        } else {
          Node<E> prev = null;
          while (tE.key != null) {
            if (tE.next == null) {
              return;
            } else {
              prev = tE;
              tE = tE.next;
            }
          }
          prev.next = tE.next;
          size--;
          return;
        }
      }
    } else {
      int hashKey = hash(key.hashCode(), table.length);
      if (table[hashKey] == null) {
        return;
      } else {
        modCount += 1;
        Node<E> tE = table[hashKey];
        if (table[hashKey].key.equals(key)) {
          Node<E> keyToRemove = table[hashKey];
          table[hashKey] = keyToRemove.next;
          size--;
          return;
        } else {
          Node<E> prev = null;
          while (tE.key == null || !(tE.key.equals(key))) {
            if (tE.next == null) {
              return;
            } else {
              prev = tE;
              tE = tE.next;
            }
          }
          Objects.requireNonNull(prev).next = tE.next;
          size--;
          return;
        }
      }
    }
  }

  @Override
  @SuppressWarnings("unchecked")
  public void clear() {
    modCount += 1;
    Node<E>[] newHashTable = (Node<E>[]) new Node[DEFAULT_CAPACITY];
    table = newHashTable;
    size = 0;
  }

  @Override
  public boolean contains(Object key) {
    if (key == null) {
      if (table[0] == null) {
        return false;
      } else {
        Node<E> tE = table[0];
        while (tE.key != null) {
          if (tE.next == null) {
            return false;
          } else {
            tE = tE.next;
          }
        }
        return true;
      }
    } else {
      Node<E> tE = table[hash(key.hashCode(), table.length)];
      if (tE == null) {
        return false;
      }
      while (tE.key == null || !(tE.key.equals(key))) {
        if (tE.next == null) {
          return false;
        } else {
          tE = tE.next;
        }
      }
      return true;
    }
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
  public boolean equals(Object o) {
    if (this.getClass().equals(o.getClass())) {
        @SuppressWarnings("unchecked")
        MyHashSet<E> obj = (MyHashSet<E>) o;
        if (this.size == obj.size) {
            for (int i = 0; i < table.length; i++) {
                if (this.table[i] != null) {
                    Node<E> e = table[i];
                    while (e != null) {
                        if (!(obj.contains(e.key))) {
                            return false;
                        }
                        if (e.next == null) {
                            break;
                        } else {
                            e = e.next;
                        }
                    }
                }
            }
            return true;
        }
    }
    return false;
  }
  
  @Override
  public Iterator<E> iterator() {
    @SuppressWarnings("unchecked")
    Node<E>[] t = (Node<E>[]) new Node[size];
    int idx = 0;
    for (int i = 0; i < table.length; i++) {
        if (this.table[i] != null) {
            Node<E> e = table[i];
            while (e != null) {
                t[idx] = e;
                ++idx;
                if (e.next == null) {
                    break;
                } else {
                    e = e.next;
                }
            }
        }
    }
    return new Iterator<E>() {
      Node<E>[] table = t;
      int size = table.length;
      Node<E> next;
      int expectedModCount = modCount;
      int index = 0;

      @Override
      public boolean hasNext() {
        if (size >= index + 1) {
          return true;
        }
        return false;
      }

      @Override
      public E next() {
        if (modCount != expectedModCount)
          throw new ConcurrentModificationException();
        if (size >= index + 1) {
          next = table[index];
          index++;
          return next.key;
        } else {
          throw new NoSuchElementException();
        }
      }
    };
  }

  @Override
  public String toString() {
    ArrayList<E> res = new ArrayList<>();
    for (int i = 0; i < table.length; i++) {
        if (this.table[i] != null) {
            Node<E> e = table[i];
            while (e != null) {
                res.add(e.key);
                if (e.next == null) {
                    break;
                } else {
                    e = e.next;
                }
            }
        }
    }
    return res.toString();
  }

  static class Node<T> {

    final int hash;
    final T key;
    Node<T> next;

    public Node(int hash, T key, Node<T> next) {
      this.hash = hash;
      this.key = key;
      this.next = next;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Node<?> node = (Node<?>) o;
      return hash == node.hash && Objects.equals(key, node.key) && Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
      return Objects.hash(hash, key, next);
    }

    @Override
    public String toString() {
      return key.toString();
    }
  }
  
  public static void main(String[] args) {
    MyHashSet<Integer> a = new MyHashSet<>();
    MyHashSet<Integer> b = new MyHashSet<>();
    a.add(5);
    b.add(5);
    System.out.println(a.equals(b));
    a.add(null);
    b.add(null);
    a.add(5);
    System.out.println(a.equals(b));
    a.remove(5);
    System.out.println(a.equals(b));
    b.add(7);
    Iterator<Integer> iter = b.iterator();
    System.out.println(iter.next());
    System.out.println(iter.next());
    System.out.println(iter.hasNext());
    b.add(9);
    System.out.println(iter.next());
  }
}
