public class MatrixClass <T> implements MatrixInterface<T> {
    private T[][] matrix;

    public MatrixClass(T[][] matrix) {
        this.matrix = matrix;
    }

    public void append(T el, int x, int y) {
        this.matrix[x][y] = el;
    }

    public void delete(int x, int y) {
        this.matrix[x][y] = null;
    }

    public T get(int x, int y) {
        return this.matrix[x][y];
    }

    
}
