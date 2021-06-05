package com.eshare.algorithm.pratice.linkedList;

/**
 * @Author Evan Leung
 **/
public class ReverseListDemo2 {

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode head = new ListNode(1);

        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(null);
        //Print node list
        ListNode.list(head);
        //ReverseList
        head = reverseBetween(head,2,4);
        //Print node list
        ListNode.list(head);
    }

    /**
     * <p>
     * before:
     * 1->2->3->4->5 , m=2,n=4
     * <p>
     * after:
     * 1->4->3->2->5
     * </p>
     *
     * @param head
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m>=n) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;

        for(int i =1 ; i<m; i++){
            head=head.next;
        }
        //找出不变化的指针
        ListNode mNode = head.next;
        ListNode preM = head;
        //用于内部排序的指针
        ListNode nNode = mNode;
        ListNode postN = nNode.next;

        //m-n区间排序
        for (int i = m; i < n; i++) {
            ListNode next = postN.next;
            postN.next = nNode;
            nNode = postN;
            postN = next;
        }

        mNode.next = postN;
        preM.next = nNode;



        return dummy.next;
    }

}
