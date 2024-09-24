package dsa.dividenconquer.java.dsa.linkedlist;

public class ReverseLinkedList2 {

    public static ListNode reverseBetween(ListNode head, int left, int right){
        ListNode curr = new ListNode(0, head);
        ListNode result = curr;
        int counter = 0;
        ListNode leftPrev = curr;
        while(counter < left){
            leftPrev = curr;
            curr = curr.next;
            counter++;
        }

        ListNode prev = null;
        while (counter <= right){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            counter++;
        }
        leftPrev.next.next = curr;
        leftPrev.next = prev;
        return result.next;
    }



    public static void main(String[] args) {
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);


        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head1;

        ListNode result = reverseBetween(head2, 1, 2);
        printList(result);
    }

    public static void printList(ListNode result){
        while(result != null){
            System.out.print(result.val);
            System.out.print(",");
            result = result.next;
        }
        System.out.println();
    }
}
