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
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (null == head || left>=right) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode leftNodePre  = dummy;
        //寻找Left的位置
        for(int i=1;i<left;i++){
            leftNodePre = leftNodePre.next;
        }

        //创建指针变量用于left对应节点操作
        ListNode leftNode = leftNodePre.next;
        ///创建指针变量用于right对应节点操作
        ListNode rightNodePre = leftNode;
        ListNode rightNodeCur = leftNode.next;

        for(int i=left;i<right;i++){
            ListNode next = rightNodeCur.next;
            rightNodeCur.next = rightNodePre;
            rightNodePre = rightNodeCur;
            rightNodeCur = next;
        }
        leftNode.next = rightNodeCur;
        leftNodePre.next = rightNodePre;


        return dummy.next;
    }

}
