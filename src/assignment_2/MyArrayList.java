package assignment_2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T> implements MyList<T> {
    private Object[] elements;
    private int size;

    public MyArrayList() {
        elements = new Object[10]; // Initial capacity
        size = 0;
    }

    @Override
    public void add(T item) {
        ensureCapacity(size + 1);
        elements[size++] = item;
    }

    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        elements[index] = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(size, item);
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return (T) elements[index];
    }

    @Override
    public T getFirst() {
        if (size == 0)
            throw new NoSuchElementException();
        return (T) elements[0];
    }

    @Override
    public T getLast() {
        if (size == 0)
            return null;
        return (T) elements[size - 1];
    }


    @Override
    public void remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public void sort() {
        Arrays.sort(elements, 0, size);
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(object, elements[i]))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(object, elements[i]))
                return i;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                return (T) elements[currentIndex++];
            }
        };
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2;
            if (newCapacity < minCapacity)
                newCapacity = minCapacity;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }
}
