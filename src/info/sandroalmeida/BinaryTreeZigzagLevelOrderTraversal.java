package info.sandroalmeida;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean goLeft = true;

        while(!queue.isEmpty()){
            int queueSize = queue.size();
            List<Integer> levelResults = new ArrayList<>();
            for(int i = 0; i < queueSize; i++){
                TreeNode current = queue.poll();
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
                levelResults.add(current.val);
            }
            if(!goLeft) Collections.reverse(levelResults);
            result.add(levelResults);
            goLeft = !goLeft;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        System.out.println(zigzagLevelOrder(root));
    }
}
