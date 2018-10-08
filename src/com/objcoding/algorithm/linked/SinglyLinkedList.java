package com.objcoding.algorithm.linked;

/**
 * 一个简单的单向链表
 *
 * @author zhangchenghui.dev@gmail.com
 * @since 2018/10/8
 */
public class SinglyLinkedList<V> {

    private int size;

    private Node<V> first = null;

    private Node<V> last = null;

    private static class Node<V> {
        V value;
        Node<V> next;

        public Node(V node) {
            this.value = node;
            this.next = null;
        }
    }


    public boolean addFirst(V value) {
        if (first == null) {
            this.first = new Node<>(value);
            this.last = first;
        } else {
            Node<V> newNode = new Node<>(value);
            newNode.next = first;
            this.first = newNode;
        }
        size++;
        return true;
    }

    public boolean addLast(V value) {
        if (last == null) {
            this.first = new Node<>(value);
            this.last = first;
        } else {
            Node<V> l = last;
            Node<V> newNode = new Node<>(value);
            this.last = newNode;
            l.next = newNode;
        }
        size++;
        return true;
    }

    public boolean add(V value, int index) {
        if (index < 0 || index > size) {
            return false;
        }
        if (index == size) { // 末尾插入
            return addLast(value);
        }
        if (index == 0) { // 表头插入
            return addFirst(value);
        }
        // 表间插入
        int pos = 1;
        Node<V> pre = first;
        Node<V> after = first.next;
        while (pos != index) {
            pre = pre.next;
            after = after.next;
            ++pos;
        }
        Node<V> newNode = new Node<>(value);
        pre.next = newNode;
        newNode.next = after;
        size++;
        return true;
    }

    public V getFirst() {
        if (first == null) {
            return null;
        }
        return first.value;
    }

    public V getLast() {
        if (last == null) {
            return null;
        }
        return last.value;
    }

    public V get(int index) {
        if (first == null) {
            return null;
        }
        int pos = 0;
        Node<V> n = first;
        while (pos != index) {
            n = n.next;
            ++pos;
        }
        return n.value;
    }

    public boolean removeFirst() {
        if (first == null) {
            return true;
        }
        Node<V> n = first.next;
        if (n == null) {
            first.value = null; // help gc
            first = null;
        } else {
            first.value = null;
            first.next = null;
            first = n;
        }
        size--;
        return true;
    }

    public boolean removeLast() {
        if (last == null) {
            return true;
        }
        Node<V> n = first.next;
        while (n != null) {


            n = n.next;
        }

        return true;
    }

    public V remove(int index) {
        return null;
    }

    public boolean remove(Object o) {
        return true;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);

        list.add(8, 7);

        int i = list.get(4);

        return;
    }
}

