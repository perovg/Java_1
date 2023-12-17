public interface MatrixInterface <T> {
    void append(T el, int x, int y);

    void delete(int x, int y);

    T get(int x, int y);
}
