package org.wqz.Code.ReorderLinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class ReorderLinkedList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 拆分链表
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = null;

        // 反转偶数位链表
        evenHead = reverseList(evenHead);

        // 合并两个有序链表
        return mergeLists(head, evenHead);
    }

    private ListNode reverseList(ListNode head) {
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

    private ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(8);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(2);

        ReorderLinkedList solution = new ReorderLinkedList();
        ListNode sortedHead = solution.sortList(head);

        // 打印排序后的链表
        while (sortedHead != null) {
            System.out.print(sortedHead.val + "->");
            sortedHead = sortedHead.next;
        }
        System.out.println("NULL");
    }
}    