package com.objcoding.algorithm.stack;

/**
 * 一个基于数组的顺序栈
 *
 * @author zhangchenghui.dev@gmail.com
 * @since 2018/10/9
 */
public class ArrayStack<V> {

    private int count; // 栈中元素个数

    private int size; // 栈大小

    private Object[] array; // 数组

    public ArrayStack(int size) {
        if (size <= 0) {
            size = 10;
        }
        array = new Object[size];
        this.size = size;
        count = 0;
    }

    public boolean push(V value) {
        if (count == size) {
            return false;
        }
        array[count] = value;
        count++;
        return true;
    }

    public V pop() {
        if (count == 0) {
            return null;
        }
        V value = (V) array[count - 1];
        array[count - 1] = null; // help gc
        count--;
        return value;
    }

    public static void main(String[] args) {

        ArrayStack<Integer> arrayStack = new ArrayStack<>(10);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);

        arrayStack.pop();
        arrayStack.pop();

        arrayStack.push(8);

        return;
    }
}
