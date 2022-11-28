package easy;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {

        if (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;

            root.right = left;
            root.left = right;

            invertTree(left);
            invertTree(right);
        }
        return root;
    }

    public static class TreeNode {
        TreeNode left;
        TreeNode right;
    }
}
