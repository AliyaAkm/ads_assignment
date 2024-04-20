package assignment_2;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyList<E> {
    private class MyNode {
        E data;
        MyNode next;
        MyNode prev;

        MyNode(E data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    @Override
    public void add(E item) {
        MyNode newNode = new MyNode(item);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void set(int index, E item) {
        MyNode node = getNode(index);
        node.data = item;
    }

    @Override
    public void add(int index, E item) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (index == size) {
            add(item);
            return;
        }
        MyNode newNode = new MyNode(item);
        MyNode current = getNode(index);
        MyNode prevNode = current.prev;
        newNode.next = current;
        current.prev = newNode;
        if (prevNode != null) {
            prevNode.next = newNode;
            newNode.prev = prevNode;
        } else {
            head = newNode;
        }
        size++;
    }

    @Override
    public void addFirst(E item) {
        add(0, item);
    }

    @Override
    public void addLast(E item) {
        add(size, item);
    }

    @Override
    public E get(int index) {
        return getNode(index).data;
    }

    @Override
    public E getFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        return head.data;
    }

    @Override
    public E getLast() {
        if (isEmpty())
            return null;
        return tail.data;
    }


    @Override
    public void remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        MyNode current = getNode(index);
        if (current.prev != null)
            current.prev.next = current.next;
        else
            head = current.next;
        if (current.next != null)
            current.next.prev = current.prev;
        else
            tail = current.prev;
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

    }

    @Override
    public int indexOf(Object object) {
        MyNode current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(object))
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.data.equals(object))
                return index;
            current = current.prev;
            index--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        MyNode current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private MyNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private MyNode getNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}

