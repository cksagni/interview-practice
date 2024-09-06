package linkedlist;



public class LinkedListCycle {
    public static boolean hasCycle(ListNode head){
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode cycle = new ListNode(2);
        cycle.next = new ListNode(0);
        cycle.next.next = new ListNode(4);
        cycle.next.next.next = cycle;
        head.next = cycle;
        System.out.println(hasCycle(head));
    }
}
