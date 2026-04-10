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

    // public Node daleteDuplicates(Node head){

    //     if (head == null)   return null;
       
    //     Node temp = head;

    //     while (temp != null && temp.next != null) {

    //         if (temp.data == temp.next.data) {
    //             temp.next = temp.next.next;
    //         }else{
    //             temp = temp.next;
    //         }
            
    //     }
     

    //     return head;

    // }


    // only unique
    public Node daleteDuplicates(Node head){

        if (head == null)   return null;

        Node dummy = new Node(0);
        dummy.next = head;

        Node prev = dummy;
        Node curr = head;
       
        
       
       while (curr!= null) {
         Boolean isDuplicate = false;
         while (curr.next != null && curr.data == curr.next.data) {

           curr = curr.next;
           isDuplicate = true;
            
        }

        if (isDuplicate) {
            prev.next = curr.next;
        }
        else{
            prev = prev.next;
        }

         curr = curr.next;
       }
     

        return dummy.next;

    }
     
}



public class _82_RemoveDuplicatesLinkList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(3);
        list.addNode(4);
        list.addNode(4);
        list.addNode(4);
        list.addNode(5);

        list.display();
        list.daleteDuplicates(list.head);
        list.display();
    }
}
