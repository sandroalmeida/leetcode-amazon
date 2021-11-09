package info.sandroalmeida;

public class DiameterBinaryTree {

    static int diameter;

    public static int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter;
    }

    public static int helper(TreeNode node){
        if(node.left == null && node.right == null) return 1;
        int left = node.left != null ? helper(node.left) : 0;
        int right = node.right != null ? helper(node.right) : 0;
        diameter = Math.max(diameter, left + right + 1);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.left.right.right.right = new TreeNode(12);
        root.left.right.right.right.right = new TreeNode(13);
        root.left.left.left.left = new TreeNode(14);
        root.left.left.left.left.left = new TreeNode(15);
        root.right = new TreeNode(3);

        System.out.println(diameterOfBinaryTree(root));
    }
}
