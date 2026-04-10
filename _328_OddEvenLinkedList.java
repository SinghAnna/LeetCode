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

    // Corrected Name: display()
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL\n");
    }

        public Node oddEvenList(Node head) {
            if (head == null || head.next == null) {
                return head;
            }
            Node odd = head;
            Node even = head.next;
            Node evenHead = even; 
            //  -> 1 -> 3 -> 5 -> 6 -> 4 -> 7 -> NULL
            // 2 -> 3 -> 6 -> 7 -> 1 -> 5 -> 4 -> NULL
            while (even != null && even.next != null) {
                odd.next = even.next;
                odd = odd.next;

                even.next = odd.next;
                even = even.next;

            }

            odd.next=evenHead;


            

            return head;

    }

}

public class _328_OddEvenLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addNode(2);
        list.addNode(1);
        list.addNode(3);
        list.addNode(5);
        list.addNode(6);
        list.addNode(4);
        list.addNode(7);

        list.display();

        list.oddEvenList(list.head);

        list.display();

    }
}
