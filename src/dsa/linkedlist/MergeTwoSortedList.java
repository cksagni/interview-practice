package dsa.linkedlist;


public class MergeTwoSortedList {
    public static ListNode mergeTwoListsR(ListNode list1, ListNode list2){
        if (list1 == null || list2 == null){
            return list1 != null ? list1 : list2;
        }
        if (list1.val <= list2.val){
            list1.next = mergeTwoListsR(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsR(list1, list2.next);
            return list2;
        }
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode result = new ListNode();
        ListNode head = result;
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        head.next = list1 != null ? list1 : list2;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);


        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);

        ListNode result = mergeTwoListsR(head1, head2);
        while(result != null){
            System.out.print(result.val);
            System.out.print(",");
            result = result.next;
        }
    }
}
