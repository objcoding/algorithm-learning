package com.objcoding.algorithm.stack;

/**
 * 一个基于单项链表的链式栈
 *
 * @author zhangchenghui.dev@gmail.com
 * @since 2018/10/9
 */
public class SinglyLinkedStack<V> {

    private Node<V> top = null;

    private static class Node<V> {
        V value;
        Node<V> next;
        public Node(V value) {
            this.value = value;
            this.next = null;
        }
    }

    public boolean push(V value) {
        if (top == null) {
            this.top = new Node<>(value);
        } else {
            Node<V> newNode = new Node<>(value);
            newNode.next = top;
            this.top = newNode;
        }
        return true;
    }

    public V pop() {
        if (top == null) {
            return null;
        }
        V value = top.value;
        top = top.next;
        return value;
    }

    public static void main(String[] args) {
        SinglyLinkedStack<Integer> singlyLinkedStack = new SinglyLinkedStack<>();

        singlyLinkedStack.push(1);
        singlyLinkedStack.push(2);
        singlyLinkedStack.push(3);
        singlyLinkedStack.push(4);
        singlyLinkedStack.push(5);

        singlyLinkedStack.pop();
        singlyLinkedStack.pop();
        singlyLinkedStack.pop();
        singlyLinkedStack.pop();
        singlyLinkedStack.pop();
        singlyLinkedStack.pop();

        singlyLinkedStack.push(7);


        return;

    }

}
