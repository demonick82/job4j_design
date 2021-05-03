package ru.job4j.collection.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Iterable<SimpleMap.Node<K, V>> {
    private final int defaultInitialCapacity = 16;
    private Node<K, V>[] table = new Node[defaultInitialCapacity];
    private float loadFactor = table.length * 0.75f;
    private int size = 0;
    private int modCount = 0;

    public boolean insert(K key, V value) {
        int hash = hash(key);
        if (size + 1 > loadFactor) {
            resizing();
        }
        int i = indexBasket(hash);
        if (table[i] == null) {
            table[i] = new Node<>(hash, key, value);
            size++;
            modCount++;
            return true;
        } else {
            if (key.equals(table[i].key)) {
                Node<K, V> node = new Node<K, V>(hash, key, value);
                table[i] = node;
            }
        }
        return false;
    }

    public Object get(K key) {
        V value = null;
        int i = indexBasket(hash(key));
        Node<K, V> node = table[i];
        if (node != null) {
            if ((key == null && node.key == null) || (key != null && key.equals(node.key))) {
                value = node.value;
            }
        }
        return value;
    }

    public boolean delete(K key) {
        boolean rsl = false;
        int i = indexBasket(hash(key));
        Node<K, V> node = table[i];
        if (node != null) {
            if ((key == null && node.key == null) || (key != null && key.equals(node.key))) {
                table[i] = null;
                rsl = true;
                size--;
                modCount++;
            }
        }
        return rsl;
    }

    private int hash(Object key) {
        int h = key.hashCode();
        return (h == 0) ? h : h ^ (h >>> 16);

    }

    private int indexBasket(int hash) {
        return (table.length - 1) & hash;
    }

    private void resizing() {
        Node<K, V>[] oldTable = table;
        table = new Node[table.length * 2];
        loadFactor = table.length * 0.75f;
        for (Node node : oldTable) {
            if (node != null) {
                table[indexBasket(node.hash)] = node;
            }
        }
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new Iterator() {
            private int cursor = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                for (int i = cursor; i < table.length; i++) {
                    if (table[i] != null) {
                        cursor = i;
                        return true;
                    }
                }
                return false;
            }

            @Override
            public Node<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[cursor++];
            }
        };
    }

    static class Node<K, V> {
        final int hash;
        final K key;
        V value;

        Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public int getHash() {
            return hash;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public final String toString() {
            return key + "=" + value;
        }
    }
}