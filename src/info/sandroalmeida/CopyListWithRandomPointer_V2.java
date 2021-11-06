package info.sandroalmeida;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer_V2 {

    static Map<Node, Node> mapNodes = new HashMap<>();

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        if(head == null) return null;

        if(mapNodes.containsKey(head))
            return mapNodes.get(head);

        Node copyNode = new Node(head.val);
        mapNodes.put(head, copyNode);

        copyNode.next = copyRandomList(head.next);
        copyNode.random = copyRandomList(head.random);

        return copyNode;
    }

    public static void main(String[] args) {
        // Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
        // Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
        // My text is printing the values for random nodes not the index

        Node head = new Node(7);
        Node node13 = new Node(13);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node1 = new Node(1);
        head.next = node13;
        node13.next = node11;
        node13.random = head;
        node11.next = node10;
        node11.random = node1;
        node10.next = node1;
        node10.random = node11;
        node1.random = head;
        printNode(head);

        Node result = copyRandomList(head);
        printNode(result);
    }

    private static void printNode(Node node){
        while(node != null){
            System.out.print(node.val + "-");
            System.out.print(node.random != null ? node.random.val : "null");
            System.out.print(", ");
            node = node.next;
        }
        System.out.println("");
    }
}
