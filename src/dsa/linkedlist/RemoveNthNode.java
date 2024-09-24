package dsa.linkedlist;

public class RemoveNthNode {
    public static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(0, head);
        ListNode toBeDeleted = dummy;
        ListNode endNode = dummy;
        while(n >= 0){
            endNode = endNode.next;
            n--;
        }
        while (endNode != null){
            endNode = endNode.next;
            toBeDeleted = toBeDeleted.next;
        }
        toBeDeleted.next = toBeDeleted.next != null ? toBeDeleted.next.next : null;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);


        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head1;

        ListNode result = removeNthFromEnd(head2, 2);
        ReverseLinkedList2.printList(result);
    }
}
