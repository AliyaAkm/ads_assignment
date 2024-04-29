package assignment_3;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BST<K extends Comparable<K>, V> implements Iterable<BST.Entry<K, V>> {

    private Node root;
    private int size;

    public static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public int size() {
        return size;
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node x, K key, V val) {
        if (x == null) {
            size++;
            return new Node(key, val);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        return x;
    }

    public V get(K key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        size--;
        return x;
    }

    private Node min(Node x) {
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new BSTIterator(root);
    }

    private class BSTIterator implements Iterator<Entry<K, V>> {
        private Node current;

        public BSTIterator(Node root) {
            current = min(root);
        }

        public boolean hasNext() {
            return current != null;
        }

        public Entry<K, V> next() {
            if (!hasNext()) throw new NoSuchElementException();
            Node node = current;
            current = successor(current);
            return new Entry<>(node.key, node.val);
        }

        private Node successor(Node x) {
            if (x.right != null) return min(x.right);
            Node succ = null;
            Node ancestor = root;
            while (ancestor != x) {
                if (x.key.compareTo(ancestor.key) < 0) {
                    succ = ancestor;
                    ancestor = ancestor.left;
                } else {
                    ancestor = ancestor.right;
                }
            }
            return succ;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}