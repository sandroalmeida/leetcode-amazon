package info.sandroalmeida;

public class ValidateBinarySearchTree {

    public static boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean helper(TreeNode node, long min, long max){
        if(node == null) return true;
        if(node.val >= max || node.val <= min) return false;
        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(1);
        head.right = new TreeNode(6);
        head.right.left = new TreeNode(4);
        head.right.right = new TreeNode(8);

        System.out.println(isValidBST(head));
    }
}
