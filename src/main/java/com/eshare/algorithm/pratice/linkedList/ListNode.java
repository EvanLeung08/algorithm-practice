package com.eshare.algorithm.pratice.linkedList;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author Evan Leung
 **/
@AllArgsConstructor
@Data
public class ListNode {

    int data;

    ListNode next;

    public ListNode(int data){
        this.data = data;
    }



    public static void list(ListNode head){
        if(head==null){
            return;
        }
        System.out.println("data:"+head.data);
        list(head.next);
    }


}
