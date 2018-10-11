package com.objcoding.algorithm.linked;


/**
 * 2.两数相加
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /**
     * 这方式只适合数值在Long型范围内，一旦数字超出Long值范围，就报错了
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long count = 1;
        long number1 = 0;
        long number2 = 0;

        while (l1 != null) {
            number1 = number1 + l1.val * count;
            count = count * 10L;
            l1 = l1.next;
        }

        count = 1L;

        while (l2 != null) {
            number2 = number2 + l2.val * count;
            count = count * 10L;
            l2 = l2.next;
        }

        ListNode head = null;
        String[] numArray = String.valueOf(number1 + number2).split("");
        for (String n : numArray) {
            ListNode newNode = new ListNode(Integer.valueOf(n));
            newNode.next = head;
            head = newNode;
        }

        return head;
    }


    /**
     * 这种方法，理论上支持无限长度的整型
     * <p>
     * 输入：
     * [2,6,6,2]
     * [5,6,4,2,4,3,2,4]
     * <p>
     * 输出：
     * [7,2,1,5,4,3,2,4]
     * <p>
     * 解题：
     * l1和l2对应的节点上相加的值等于l的对应节点的值，
     * 注意还需要对「逢十进一」进行处理
     * <p>
     * 时间复杂度：O(max(m,n)) (假设l1的长度为m，l2的长度为n)
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode first = null;
        ListNode last = null;
        int tenIntoOne = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            int val = sum + tenIntoOne;
            ListNode newNode = new ListNode(val % 10);
            if (first == null) {
                first = newNode;
                last = newNode;
            } else {
                last.next = newNode;
                last = newNode;
            }
            // 给下一位进行逢十进一
            tenIntoOne = val / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //  tenIntoOne > 0 防止最后一位还有逢十进一
        if (tenIntoOne > 0) {
            last.next = new ListNode(tenIntoOne);
        }
        return first;
    }


}
