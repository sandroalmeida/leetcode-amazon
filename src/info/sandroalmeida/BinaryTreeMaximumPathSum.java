package info.sandroalmeida;

public class BinaryTreeMaximumPathSum {

    static int maxPath;

    public static int maxPathSum(TreeNode root) {
        maxPath = Integer.MIN_VALUE;
        helper(root);
        return maxPath;
    }

    private static int helper(TreeNode node){
        if(node.left == null && node.right == null)
            return node.val;
        int left = node.left == null ? 0 : helper(node.left);
        int right = node.right == null ? 0 : helper(node.right);

        maxPath = Math.max(maxPath, left + right + node.val);
        return Math.max(left, right) + node.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxPathSum(root));
    }
}
