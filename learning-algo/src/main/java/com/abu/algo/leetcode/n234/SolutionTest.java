package com.abu.algo.leetcode.n234;

import com.abu.algo.leetcode.common.ListNode;

/**
 * Created by zhewawan on 2019/11/19.
 */
public class SolutionTest {

    public static void main(String[] args) {

        ListNode listNode = initListNode();
        print(listNode);
        System.out.println(new Solution().isPalindrome(listNode));
    }

    private static ListNode initListNode(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        return node1;
    }

    private static void print(ListNode listNode){
        StringBuilder sb = new StringBuilder(20);
        while(listNode != null){
            sb.append(listNode.val).append("->");
            listNode = listNode.next;
        }
        sb.append("NULL");
        System.out.println(sb);
    }
}
