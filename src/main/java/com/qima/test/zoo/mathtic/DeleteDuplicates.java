package com.qima.test.zoo.mathtic;

/**
 * 给定一个已排序的链表的头 head ，
 * 删除所有重复的元素，使每个元素只
 * 出现一次 。返回 已排序的链表
 * @author A80390
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(deleteDuplicates1(node1).toString());
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}
