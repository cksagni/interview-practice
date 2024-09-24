package dsa.linkedlist;

public class ReverseLinkedLIst {

    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }


    public static ListNode reverseR(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode newNode = reverseR(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }



    public static void main(String[] args) {
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);


        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head1;

        ListNode curr = head2;
        while(curr != null){
            System.out.print(curr.val);
            System.out.print(",");
            curr = curr.next;
        }
        System.out.println();

        ListNode result = reverseR(head2);

        while(result != null){
            System.out.print(result.val);
            System.out.print(",");
            result = result.next;
        }
    }

}
