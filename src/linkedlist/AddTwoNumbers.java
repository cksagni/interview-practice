package linkedlist;




/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */


public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode result = new ListNode();
        int total, carry = 0, x, y;
        ListNode head = result;
        while (l1 != null || l2 != null || carry != 0){
            x = l1 != null ? l1.val : 0;
            y = l2 != null ? l2.val : 0;
            total = x + y + carry;
            carry = total / 10;
            total = total % 10;
            head.next = new ListNode(total);
            head = head.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(9);
        head1.next = new ListNode(9);
        head1.next.next = new ListNode(9);


        ListNode head2 = new ListNode(9);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(9);

        ListNode result = addTwoNumbers(head1, head2);
        while(result != null){
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println();
    }
}
