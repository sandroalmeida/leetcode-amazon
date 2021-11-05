package info.sandroalmeida;

public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode current1 = l1;
        ListNode current2 = l2;
        ListNode dummyNode = new ListNode();
        ListNode newNode = dummyNode;

        while(current1 != null && current2 != null){
            if (current1.val <= current2.val) {
                newNode.next = current1;
                newNode = newNode.next;
                current1 = current1.next;
            } else{
                newNode.next = current2;
                newNode = newNode.next;
                current2 = current2.next;
            }
        }

        if(current1 == null)
            newNode.next = current2;
        else
            newNode.next = current1;

        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);

        ListNode result = mergeTwoLists(l1, l2);
        while(result != null){
            System.out.print(result.val + " - ");
            result = result.next;
        }
    }
}
