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

    void reverse() {
        Node curr = head;
        Node prev = null;

        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head = prev;
    }

    Node reverseRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newNode = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }
}

public class _1669_mergeBetweenTwoLinkedList {

      public static LinkedList mergeInBetween(LinkedList list1, int a, int b, LinkedList list2) {
    // Find the node just BEFORE the a-th node
    Node prevA = list1.head;
    for (int i = 0; i < a - 1; i++) {
        prevA = prevA.next;
    }

    // Find the node at position b
    Node postB = prevA;
    for (int i = a - 1; i <= b; i++) {
        postB = postB.next;
    }

    // Find last node in list2
    Node tail2 = list2.head;
    while (tail2.next != null) {
        tail2 = tail2.next;
    }

    // Do the merge
    prevA.next = list2.head;
    tail2.next = postB;

    return list1;
}


    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list1.addNode(10);
        list1.addNode(1);
        list1.addNode(13);
        list1.addNode(6);
        list1.addNode(9);
        list1.addNode(5);

        list2.addNode(1000000);
        list2.addNode(1000001);
        list2.addNode(1000002);

        list1.display();
        list2.display();

        mergeInBetween(list1, 3, 4, list2);

        list1.display();

    }
}
