import java.util.*;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode pop = que.poll();
                level.add(pop.val);

                if (pop.left != null) que.offer(pop.left);
                if (pop.right != null) que.offer(pop.right);
            }

            // 🔥 main interview line
            ans.addFirst(level);
        }

        return ans;
    }
}

public class _107_LevelOrderTraversal {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> ans = root.levelOrderBottom(root);
        System.out.println(ans);
    }
}
