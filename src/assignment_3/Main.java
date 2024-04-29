package assignment_3;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>();

        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(random.nextInt(100), "Element-" + i);
            table.put(key, "Value-" + i);
        }

        table.printBucketSizes();
        BST<Integer, String> bst = new BST<>();
        for (int i = 0; i < 10000; i++) {
            bst.put(random.nextInt(100), "Value-" + i);
        }

        System.out.println("Size of BST: " + bst.size());

        for (BST.Entry<Integer, String> entry : bst) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

    }
}
