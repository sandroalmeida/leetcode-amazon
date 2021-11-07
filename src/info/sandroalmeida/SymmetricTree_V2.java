package info.sandroalmeida;

public class SymmetricTree_V2 {

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;

        return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
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
