package solutions;

import utils.ListNode;

import java.util.Stack;

public class p2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = null;
        ListNode head = null;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int a = 0, b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            int sum = a + b + carry;
            carry = 0;
            if (sum > 9) {
                sum = sum - 10;
                carry = 1;
            }

            ListNode newNode = new ListNode(sum);

            if (node == null) {
                head = newNode;
                node = newNode;
            } else {
                node.next = newNode;
                node = node.next;
            }
        }

        if (carry == 1) {
            node.next = new ListNode(1);
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = genIntList(12);
        ListNode l2 = genIntList(0);

        Stack stack = list2Stack(addTwoNumbers(l1, l2));
        while (!stack.empty()) {
            System.out.print(stack.pop());
        }
    }

    private static ListNode genIntList(int input) {
        int i = 0;
        while ((input / (int)Math.pow(10, i)) != 0) {
            ++i;
        }

        ListNode node = null;

        while (i > 0) {
            int currentNum = input / (int)Math.pow(10, --i);
            ListNode newNode = new ListNode(currentNum);

            newNode.next = node;
            node = newNode;

            input = input % (int)Math.pow(10, i);
        }

        return node;
    }

    private static Stack list2Stack(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();

        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        return stack;
    }
}
