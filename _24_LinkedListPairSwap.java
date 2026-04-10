
public class _24_LinkedListPairSwap {

    public static class Node {
        int data; // value
        Node next; // next address

        Node(int data) {
            this.data = data;
        }

        // best approch
        public static Node swapPairNode(Node head){
        if (head == null || head.next == null) {
        return head;
        }
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        while (prev.next != null && prev.next.next != null) {
        Node a = prev.next;
        Node b = a.next;

        // swap a and b
        prev.next = b;
        a.next = b.next;
        b.next = a;

        // move prev two nodes forward
        prev = a;
        }

        return dummy.next;
        }

        // public static Node swapPairNodeRecursive(Node head) {
        //     // base case
        //     if (head == null || head.next == null) {
        //         return head;
        //     }

        //     // nodes to be swapped
        //     Node first = head;
        //     Node second = head.next;

        //     // recursion on the rest of the list
        //     first.next = swapPairNodeRecursive(second.next);

        //     // swap
        //     second.next = first;

        //     // return new head (second becomes the new head of this pair)
        //     return second;
        // }

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node p1 = new Node(2);
        Node p2 = new Node(3);
        Node p3 = new Node(4);

        head.next = p1;
        p1.next = p2;
        p2.next = p3;

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("Null");

        Node rs = Node.swapPairNode(head);

        // Node rs = Node.swapPairNodeRecursive(head);

        // print swapped list
        Node t2 = rs;
        while (t2 != null) {
            System.out.print(t2.data + "->");
            t2 = t2.next;
        }
        System.out.println("Null");
    }
}
