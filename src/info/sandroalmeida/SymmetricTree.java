package info.sandroalmeida;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        List<String> leftValues = new ArrayList<>();
        List<String> rightValues = new ArrayList<>();

        if(root.left != null) traverseLeft(root.left, leftValues, "");
        if(root.right != null) traverseRight(root.right, rightValues, "");

        if(leftValues.size() != rightValues.size())
            return false;

        for(int i = 0; i < leftValues.size(); i++){
            if(!leftValues.get(i).equals(rightValues.get(i)))
                return false;
        }

        return true;
    }

    public static void traverseLeft(TreeNode node, List<String> values, String direction){
        if(node.left != null) traverseLeft(node.left, values, "L");
        values.add(node.val + direction);
        if(node.right != null) traverseLeft(node.right, values, "R");
    }

    public static void traverseRight(TreeNode node, List<String> values, String direction){
        if(node.right != null) traverseRight(node.right, values, "L");
        values.add(node.val + direction);
        if(node.left != null) traverseRight(node.left, values, "R");
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

        System.out.println(isSymmetric(head3));
    }
}
