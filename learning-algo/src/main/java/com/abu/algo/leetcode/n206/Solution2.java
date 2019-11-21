package com.abu.algo.leetcode.n206;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhewawan on 2019/11/20.
 * 迭代算法
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode/
 */
public class Solution2 {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }


}
