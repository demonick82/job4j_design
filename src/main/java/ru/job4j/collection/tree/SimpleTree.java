package ru.job4j.collection.tree;

import java.util.*;
import java.util.function.BiPredicate;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> parentNode = findBy(parent);
        if (parentNode.isPresent() || findBy(child).isEmpty()) {
            parentNode.get().children.add(new Node<>(child));
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        BiPredicate<Node<E>, E> pred = (node, val) -> node.value.equals(val);
        return findByPredicate(pred, value);
    }

    @Override
    public boolean isBinary() {
        BiPredicate<Node<E>, E> pred = (node, val) -> node.children.size() > 2;
        return findByPredicate(pred, null).isEmpty();
    }

    private Optional<Node<E>> findByPredicate(BiPredicate<Node<E>, E> pred, E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (pred.test(el, value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
