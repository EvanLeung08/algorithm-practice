package com.eshare.algorithm.pratice.linkedList;

import java.util.List;

/**
 * @Author Evan Leung
 **/
public class ReverseListDemo {

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4= new ListNode(4);
        ListNode node3= new ListNode(3);
        ListNode node2= new ListNode(2);
        ListNode head= new ListNode(1);

        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(null);
        //Print node list
        ListNode.list(head);
        //ReverseList
        head = reverseList(head);
        //Print node list
        ListNode.list(head);
    }

    /**
     * <p>
     * before:
     * 1->2->3->4->5
     *
     * after:
     * 5->4->3->2->1
     * </p>
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head){
        if(head ==null){
            return null;
        }

        ListNode pre = head;
        ListNode current = head.next;
        pre.next = null;
        while(current!=null){
            ListNode next = current.next;
            current.next=pre;
            pre = current;
            current = next;

        }

        return pre;
    }

}
