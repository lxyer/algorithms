package com.lxyer.algorithms.code;


public class LinkedListDemo {
    /**
     * 判断链表是否有环
     * @param head
     * @return
     */
    public static boolean isCycle(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p1 = p2.next.next;
            if (p1==p2) {
                return true;
            }
        }
        return false;
    }
    private static class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
}
