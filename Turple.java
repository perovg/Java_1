public class Turple<T> {
    private T[] turple;
    private int len;

    private int searchingFree() {
        int free = 0;
        for (; free < len; free++) {
            if (turple[free] == null) {
                break;
            }
        } 
        return free;
    }

    public Turple(int x) {
        len = x;
        this.turple = (T[]) new Object[x];
    }

    public T get(int index) {
        try {
            return turple[index];
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e + " Индекс вне кортежа");
            return null;
        }
    }

    public void add(T el) {
        try {
            turple[searchingFree()] = el;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Кортеж заполнен");
        }
    }

    public void add(T el, int index) {
        try {
            turple[index] = el;
        } catch (IndexOutOfBoundsException e){
            System.out.println(e +  " Индекс вне кортежа");
        } 
    }

    public void remove(int index) {
        try {
            turple[index] = null;
        } catch (IndexOutOfBoundsException e){
            System.out.println(e +  " Индекс вне кортежа");
        } 
    }

    public void remove(T el) {
        for (int i = 0; i < len; i++) {
            if (turple[i].equals(el)) {
                remove(i);
                break;
            }
        }
    }

    public boolean isEmpty() {
        return (searchingFree() != 0);
    }

    public T orElse(int i, T defaultValue) {
        try {
            if (0 <= i && i < len && turple[i] != null) {
                return turple[i];
            }
        } catch (IndexOutOfBoundsException e){
            System.out.println(e + " Индекс вне кортежа");
        } 
        return defaultValue;
    }
}
