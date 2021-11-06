package info.sandroalmeida;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

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

        Map<Node, Node> mapNodes = new HashMap<>();
        Node dummyNode = new Node(-1);
        Node current = head;
        Node currentCopy = null;

        while(current != null){
            Node copyNode;
            if(!mapNodes.containsKey(current)){
                copyNode = new Node(current.val);
                mapNodes.put(current, copyNode);
            } else{
                copyNode = mapNodes.get(current);
            }

            if(current.random != null){
                if(mapNodes.containsKey(current.random)){
                    copyNode.random = mapNodes.get(current.random);
                } else{
                    Node newRandom = new Node(current.random.val);
                    mapNodes.put(current.random, newRandom);
                    copyNode.random = newRandom;
                }
            }

            if(currentCopy == null) {
                dummyNode.next = copyNode;
                currentCopy = copyNode;
            } else{
                currentCopy.next = copyNode;
                currentCopy = currentCopy.next;
            }

            current = current.next;
        }
        return dummyNode.next;
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
