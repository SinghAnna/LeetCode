import java.util.HashSet;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        next = null;
    }
}

public class _817_LinkedlistComponents {

    public static int numComponents(Node head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }

        int count = 0;
        Node temp = head;

        while (temp != null) {

            // start of a component
            if (set.contains(temp.val)) {

                count++;

                // skip whole connected component
                while (temp != null && set.contains(temp.val)) {
                    temp = temp.next;
                }
            } else {
                temp = temp.next;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);

        int[] nums = {0, 3, 1, 4};

        int res = numComponents(head, nums);

        System.out.println(res); // Output: 2
    }
}