package assignment_3;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

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
        if (root == null) {
            root = new Node(key, val);
            size++;
            return;
        }

        Node current = root;
        Node parent = null;
        while (current != null) {
            parent = current;
            int cmp = key.compareTo(current.key);
            if (cmp < 0)
                current = current.left;
            else if (cmp > 0)
                current = current.right;
            else {
                current.val = val;
                return;
            }
        }

        int cmp = key.compareTo(parent.key);
        if (cmp < 0)
            parent.left = new Node(key, val);
        else
            parent.right = new Node(key, val);
        size++;
    }

    public V get(K key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0)
                x = x.left;
            else if (cmp > 0)
                x = x.right;
            else
                return x.val;
        }
        return null;
    }

    public void delete(K key) {
        if (root == null) return;

        Node parent = null;
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp == 0) break;
            parent = current;
            if (cmp < 0)
                current = current.left;
            else
                current = current.right;
        }

        if (current == null) return;

        if (current.left == null && current.right == null) {
            if (parent == null)
                root = null;
            else if (parent.left == current)
                parent.left = null;
            else
                parent.right = null;
        } else if (current.left == null || current.right == null) {
            Node child = (current.left != null) ? current.left : current.right;
            if (parent == null)
                root = child;
            else if (parent.left == current)
                parent.left = child;
            else
                parent.right = child;
        } else {
            Node successorParent = current;
            Node successor = current.right;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            current.key = successor.key;
            current.val = successor.val;
            if (successorParent.left == successor)
                successorParent.left = successor.right;
            else
                successorParent.right = successor.right;
        }
        size--;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new BSTIterator(root);
    }

    private class BSTIterator implements Iterator<Entry<K, V>> {
        private Stack<Node> stack;

        public BSTIterator(Node root) {
            stack = new Stack<>();
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public Entry<K, V> next() {
            if (!hasNext()) throw new NoSuchElementException();
            Node node = stack.pop();
            Node current = node.right;
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            return new Entry<>(node.key, node.val);
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
