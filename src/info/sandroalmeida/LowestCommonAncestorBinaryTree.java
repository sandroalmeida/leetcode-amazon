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
}
