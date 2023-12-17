public class Pair<T extends Comparable<T>> {
  private T left;
  private T right;

  public Pair(T left, T right) {
    this.left = left;
    this.right = right;
  }

  public T getLeft() {
    return left;
  }

  public void setLeft(T left) {
    this.left = left;
  }

  public T getRight() {
    return right;
  }

  public void setRight(T right) {
    this.right = right;
  }

  public T min() {
    if (compare() > 0) {
        return right;
    } else {
        return left;
    }
  }

  public T max() {
    if (compare() > 0) {
        return left;
    } else {
        return right;
    }
  }

  private int compare() {
    return left.compareTo(right);
  }
}