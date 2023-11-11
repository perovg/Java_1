import java.util.NoSuchElementException;

public class MyDeque<T> implements Deque<T> {
    public MyStack<T> firstStack = new MyStack<T>();
    public MyStack<T> secondStack = new MyStack<T>();
    
    @Override
    public void addFirst(T el) {
        firstStack.push(el);
    }
    
    @Override
    public void addLast(T el) {
        while (firstStack.size() != 0) {
            secondStack.push(firstStack.pop());
        }
        secondStack.push(el);
        while (secondStack.size() != 0) {
            firstStack.push(secondStack.pop());
        }
    }

    @Override
    public T removeFirst() {
        if (firstStack.size() == 0) {
            throw new NoSuchElementException();
        } else {
            return firstStack.pop();
        }
    }

    @Override
    public T removeLast() {
        if (firstStack.size() == 0) {
            throw new NoSuchElementException();
        } else {
            while (firstStack.size() != 0) {
                secondStack.push(firstStack.pop());
            }
            T last = secondStack.pop();
            while (secondStack.size() != 0) {
                firstStack.push(secondStack.pop());
            }
            return last;
        }
    }

    @Override
    public T peekFirst() {
        return firstStack.peek();
    }

    @Override
    public T peekLast() {
        while (firstStack.size() != 0) {
            secondStack.push(firstStack.pop());
        }
        T last = secondStack.peek();
        while (secondStack.size() != 0) {
            firstStack.push(secondStack.pop());
        }
        return last;
    }

    @Override
    public boolean isEmpty() {
        return firstStack.isEmpty();
    }

    @Override
    public void printDeque() {
        while (firstStack.size() != 0) {
            secondStack.push(firstStack.pop());
        }
        while (secondStack.size() != 0) {
            T output = secondStack.pop();
            firstStack.push(output);
            System.out.print(output + " ");
        }
        System.out.println();
    }

    @Override
    public int size() {
        return firstStack.size();
    }
}