
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.right = right;
        this.left = left;
    }

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null)
            return -1;

        // If leaf node
        if (root.left == null && root.right == null)
            return -1;

        int left = root.left.val;
        int right = root.right.val;

        // If child value equals root, go deeper
        if (left == root.val)
            left = findSecondMinimumValue(root.left);

        if (right == root.val)
            right = findSecondMinimumValue(root.right);

        if (left != -1 && right != -1)
            return Math.min(left, right);

        return Math.max(left, right);
    }

    void printTree(TreeNode root) {

        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);

    }
}

public class _671_SecondMinimum {
    public static void main(String... args) {
        TreeNode root = new TreeNode(2);

        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(7);

        root.printTree(root);

        int val = root.findSecondMinimumValue(root);
        System.out.println(val);
    }
}
