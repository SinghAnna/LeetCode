class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(){

    }

    TreeNode(int val){
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}



public class _98_ValiddateBinarySearchTree {

 public boolean isValidBST(TreeNode root) {
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

boolean helper(TreeNode root, long left, long right){
        if (root == null) {
            return true;
        }

        if (root.val <= left || root.val >= right) {
            return false;
        }

        return helper(root.left, left, root.val) &&  helper(root.right, root.val, right);
}

    public static void main(String[] args) {
        TreeNode tNode = new TreeNode(5);
        tNode.left = new TreeNode(1);
        tNode.right = new TreeNode(4);
        tNode.right.left =  new TreeNode(3);
        tNode.right.right = new TreeNode(6);


        _98_ValiddateBinarySearchTree checkBinarySearchTree = new _98_ValiddateBinarySearchTree();

        System.out.println(checkBinarySearchTree.isValidBST(tNode));
      
    }
}
