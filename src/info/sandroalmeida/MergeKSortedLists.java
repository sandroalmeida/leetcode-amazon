package info.sandroalmeida;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for(ListNode node: lists){
            ListNode current = node;
            while(current != null) {
                minHeap.add(new ListNode(current.val));
                current = current.next;
            }
        }
        ListNode head = minHeap.poll();
        ListNode current = head;
        while(!minHeap.isEmpty()){
            current.next = minHeap.poll();
            current = current.next;
        }
        return head;
    }

}
