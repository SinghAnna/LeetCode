class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL\n");
    }
}

// Tree Node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class _109_ListToTree {

    // Make a copy of the list so original does not break
    public Node copyList(Node head) {
        if (head == null) return null;

        Node newHead = new Node(head.data);
        Node temp = newHead;
        Node curr = head.next;

        while (curr != null) {
            temp.next = new Node(curr.data);
            temp = temp.next;
            curr = curr.next;
        }
        return newHead;
    }

    // Convert sorted linked list to BST
    public TreeNode sortedListToBST(Node head) {
        if (head == null) return null;

        if (head.next == null) {
            return new TreeNode(head.data);
        }

        Node slow = head;
        Node fast = head;
        Node prev = null;

        // Find middle
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Disconnect left half
        prev.next = null;

        TreeNode root = new TreeNode(slow.data);

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;
    }

    // Print BST preorder
    public void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addNode(-10);
        list.addNode(-3);
        list.addNode(0);
        list.addNode(5);
        list.addNode(9);

        System.out.println("Original Linked List:");
        list.display();

        _109_ListToTree convert = new _109_ListToTree();

        // Copy list so original remains safe
        Node copyHead = convert.copyList(list.head);

        // Convert to BST
        TreeNode root = convert.sortedListToBST(copyHead);

        // Display original list
        System.out.println("\nOriginal Linked List after BST conversion:");
        list.display();

        // Display BST
        System.out.println("\nPreorder Traversal of BST:");
        convert.preorder(root);
    }
}
