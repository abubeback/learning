package com.abu.algo.leetcode.n206;

/**
 * Created by zhewawan on 2019/11/19.
 */
public class SolutionTest {

    public static void main(String[] args) {

        ListNode listNode = initListNode();
        print(listNode);

        Solution1 s1 = new Solution1();
        listNode = s1.reverseList(listNode);
        print(listNode);

        listNode = initListNode();
        print(listNode);
        Solution2 s2 = new Solution2();
        listNode = s2.reverseList(listNode);
        print(listNode);
    }

    private static ListNode initListNode(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
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
