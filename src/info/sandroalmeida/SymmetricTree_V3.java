package info.sandroalmeida;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree_V3 {

    public static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if(t1 == null && t2 == null) continue;
            if(t1 == null || t2 == null) return false;
            if(t1.val != t2.val) return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(2);
        head.left.left = new TreeNode(3);
        head.left.right = new TreeNode(4);
        head.right.left = new TreeNode(4);
        head.right.right = new TreeNode(3);

        TreeNode head2 = new TreeNode(1);
        head2.left = new TreeNode(2);
        head2.right = new TreeNode(2);
        head2.left.left = new TreeNode(2);
        head2.right.left = new TreeNode(2);

        TreeNode head3 = new TreeNode(1);
        head3.left = new TreeNode(0);

        System.out.println(isSymmetric(head));
        System.out.println(isSymmetric(head2));
        System.out.println(isSymmetric(head3));
    }
}
