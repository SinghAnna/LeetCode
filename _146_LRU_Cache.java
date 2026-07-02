import java.util.HashMap;

class Node {
    int key, val;

    Node prev, next;

    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

public class _146_LRU_Cache {


    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head, tail;

    _146_LRU_Cache(int capacity){
         this.capacity = capacity;
        this.map = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        insertAtFront(node);
        
        return node.val;
    }

    public void put(int key , int val){
        if (map.containsKey(key)) {
            Node oldNode = map.get(key);
            remove(oldNode);
        }

        if(map.size() == capacity){
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        Node newNode = new Node(key, val);
        insertAtFront(newNode);
        map.put(key, newNode);
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtFront(Node node){
        node.next = head.next;
        node.prev= head;
        
        head.next.prev = node;
        head.next = node;
    }

    public static void main(String[] args) {
        
    }
}
