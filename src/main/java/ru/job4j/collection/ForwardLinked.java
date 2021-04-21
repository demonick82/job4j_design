package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {

    private Node<T> head;
    private int size = 0;

    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        size++;
        tail.next = node;
    }

    public T deleteFirst() {
        Node<T> node = head;
        if (head == null) {
            throw new NoSuchElementException();
        }
        head = head.next;
        size--;
        return node.value;
    }

    public void addFirst(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        node.next = head;
        size++;
        head = node;
    }

    public int size() {
        return size;
    }

    public boolean revert() {
        Node tmp = head;
        head = null;
        if (size == 0 || size == 1) {
            return false;
        }
        while (tmp != null) {
            Node<T> parent = tmp;
            tmp = tmp.next;
            parent.next = head;
            head = parent;
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
