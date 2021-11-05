package info.sandroalmeida;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode current1 = l1;
        ListNode current2 = l2;
        int carry = 0;
        ListNode dummyNode = new ListNode();
        ListNode newNode = dummyNode;

        while(current1 != null || current2 != null || carry > 0){
            int val1 = current1 != null ? current1.val : 0;
            int val2 = current2 != null ? current2.val : 0;
            int sum = val1 + val2 + carry;
            int digit = sum % 10;
            carry = sum / 10;
            newNode.next = new ListNode(digit);
            newNode = newNode.next;
            if(current1 != null) current1 = current1.next;
            if(current2 != null) current2 = current2.next;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        // Input: l1 = [9,9,9,9,9,9,9]
        //        l2 = [9,9,9,9]
        // Output:     [8,9,9,9,0,0,0,1]
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        ListNode result = addTwoNumbers(l1, l2);
        while(result != null){
            System.out.print(result.val + " - ");
            result = result.next;
        }
    }
}
