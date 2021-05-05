package com.qdm.datastruct.leetcode;

/**
 *
 *给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 *
 *
 *
 *
 */
public class MergeKLists {


    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);


        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] input = new ListNode[]{
               list1,list2
        };

        ListNode listNode = mergeKLists(input);
        System.out.println("listNode = " + listNode);


    }




    public static ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;

        ListNode res = new ListNode();
        while(true) {
            ListNode tmpMin = null;
            int minIdx = -1;
            int left = size;
            for (int i=0;i<size;i++) {
                ListNode curr = lists[i];
                if(curr == null) {
                    left--;
                    continue;
                } else {
                    if (tmpMin == null ) {
                        minIdx = i;
                        tmpMin = curr;
                    } else if(curr.val < tmpMin.val) {
                        minIdx = i;
                        tmpMin = curr;
                    }
                }
            }

            if( tmpMin != null ) {
                if (res.next == null) {
                    res.next = new ListNode(tmpMin.val);
                } else {
                    ListNode curR = res;
                    while (true) {
                        if (curR.next == null) {
                            curR.next = new ListNode(tmpMin.val);
                            break;
                        }
                        curR = curR.next;
                    }

                }
                if(minIdx != -1) {
                    if (tmpMin.next == null) {
                        left--;
                        lists[minIdx] = null;
                    } else {
                        lists[minIdx] = lists[minIdx].next;
                    }

                }
            }

            if (left == 0) {
                break;
            }
        }
        return res.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }


}


