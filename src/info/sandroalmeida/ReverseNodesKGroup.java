package info.sandroalmeida;

public class ReverseNodesKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode current = head;

        while(count < k && current != null){
            current = current.next;
            count++;
        }

        if(count == k){
            ListNode reversedHead = reverseSegment(head, k);
            head.next = reverseKGroup(current, k);
            return reversedHead;
        }
        return head;
    }


    private static ListNode reverseSegment(ListNode head, int k){
        ListNode newHead = null;
        ListNode current = head;

        while(k > 0){
            ListNode nextNode = current.next;
            current.next = newHead;
            newHead = current;
            current = nextNode;
            k--;

        }
        return newHead;
    }

    public static void main(String[] args) {
        // Input: head = [1,2,3,4,5], k = 2
        // Output: [2,1,4,3,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode current = reverseKGroup(head, 2);
        while(current != null){
            System.out.print(current.val + "-");
            current = current.next;
        }
    }
}
