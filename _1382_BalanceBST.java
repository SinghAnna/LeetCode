import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    List<Integer> inorder = new ArrayList<>();

    // Step 1: balance BST
    public TreeNode balanceBST(TreeNode root) {
        inorder.clear();
        fillInorder(root);              //  list fill
        return buildBalancedBST(0, inorder.size() - 1);
    }

    // Step 2: build balanced tree
    private TreeNode buildBalancedBST(int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(inorder.get(mid));

        root.left = buildBalancedBST(left, mid - 1);
        root.right = buildBalancedBST(mid + 1, right);

        return root;
    }

    // inorder for LIST
    void fillInorder(TreeNode root) {
        if (root == null) return;

        fillInorder(root.left);
        inorder.add(root.val);
        fillInorder(root.right);
    }

    //  inorder for PRINT
    void printInorder(TreeNode root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}

public class _1382_BalanceBST {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        TreeNode balancedRoot = root.balanceBST(root);

        balancedRoot.printInorder(balancedRoot); // ✅ no NPE
    }
}
