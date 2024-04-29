package assignment_3;

public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;


        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
        @Override
        public String toString() {
            return "[" + key + ": " + value + "]";
        }
    }

    private HashNode<K, V>[] table;
    private int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashTable() {
        this.capacity = 11;
        this.table = (HashNode<K, V>[]) new HashNode[capacity];
        this.size = 0;
    }

    public MyHashTable(int capacity) {
        this.capacity = capacity;
        this.table = (HashNode<K, V>[]) new HashNode[capacity];
        this.size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> newNode = new HashNode<>(key, value);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            HashNode<K, V> current = table[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> current = table[index];
        HashNode<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    public boolean contains(V value) {
        for (int i = 0; i < capacity; i++) {
            HashNode<K, V> current = table[i];
            while (current != null) {
                if (current.value.equals(value)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (int i = 0; i < capacity; i++) {
            HashNode<K, V> current = table[i];
            while (current != null) {
                if (current.value.equals(value)) {
                    return current.key;
                }
                current = current.next;
            }
        }
        return null;
    }
    public void printBucketSizes() {
        int[] bucketSizes = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            int count = 0;
            HashNode<K, V> current = table[i];
            while (current != null) {
                count++;
                current = current.next;
            }
            bucketSizes[i] = count;
        }

        for (int i = 0; i < capacity; i++) {
            System.out.println("Bucket " + i + ": " + bucketSizes[i] + " elements");
        }
    }

}

