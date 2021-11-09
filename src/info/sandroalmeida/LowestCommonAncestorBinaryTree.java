package info.sandroalmeida;

public class LowestCommonAncestorBinaryTree {

    static TreeNode commonAncestor;

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return commonAncestor;
    }

    private static boolean helper(TreeNode currentNode, TreeNode p, TreeNode q){
        if(currentNode == null) return false;
        int left = helper(currentNode.left, p, q) ? 1 : 0;
        int right = helper(currentNode.right, p, q) ? 1 : 0;
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;
        if(mid + left + right >= 2)
            commonAncestor = currentNode;
        return (mid + left + right) > 0;
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
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);

        System.out.println(lowestCommonAncestor(root, root.left.left.right, root.left.right.right).val);
    }
}
