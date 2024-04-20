package assignment_2;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        //test for ArrayList
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(10);
        list.addFirst(5);
        list.addLast(15);

        System.out.println("Element at index 1: " + list.get(1));
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());

        list.set(1, 20);
        System.out.println("New element at index 1: " + list.get(1));

        list.remove(1);
        System.out.println("Element at index 1 after remove: " + list.get(1));
        list.removeFirst();
        System.out.println("First element after removeFirst: " + list.getFirst());
        list.removeLast();
        System.out.println("Last element after removeLast: " + list.getLast());

        list.add(30);
        list.add(10);
        list.add(20);
        System.out.println("Before sorting: " + Arrays.toString(list.toArray()));
        list.sort();
        System.out.println("After sorting: " + Arrays.toString(list.toArray()));

        list.add(20);
        list.add(30);
        System.out.println("Index of 20: " + list.indexOf(20));
        System.out.println("Last index of 20: " + list.lastIndexOf(20));
        System.out.println("Does 10 exist? " + list.exists(10));
        System.out.println("Does 20 exist? " + list.exists(20));

        list.clear();
        System.out.println("Size after clear: " + list.size());
    }
}
