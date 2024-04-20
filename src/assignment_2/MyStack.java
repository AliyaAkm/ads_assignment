package assignment_2;

import java.util.EmptyStackException;

public class MyStack<T> {
    private MyArrayList<T> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();
        T item = list.getLast();
        list.removeLast();
        return item;
    }

    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}
