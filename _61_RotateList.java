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


    
Node rotateRight(Node head, int k) {
    if (head == null || head.next == null || k == 0)
        return head;

    // 1. Find length and tail
    int n = 1;
    Node tail = head;
    while (tail.next != null) {
        tail = tail.next;
        n++;
    }

    // 2. Make the list circular
    tail.next = head;

    // 3. Find the new tail: (n - k % n - 1)th node
    k = k % n;
    int stepsToNewTail = n - k;
    Node newTail = tail;
    while (stepsToNewTail-- > 0) {
        newTail = newTail.next;
    }

    // 4. The node after newTail is the new head
    Node newHead = newTail.next;
    newTail.next = null;

    return newHead;
}



     
}


public class _61_RotateList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
       
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
       
        list.display();

        list.head = list.rotateRight(list.head, 2);

        list.display();


    }

}
