class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}


public class _148_SortList {

    public static ListNode sortList(ListNode head){

        //base case
        if (head == null || head.next == null) {
            return head;
        }

        //step 1 find middle
        ListNode mid = getMid(head);
        ListNode right = mid.next;

        mid.next = null;

        //step 2 Sort Both halves
        ListNode leftSort = sortList(head);
        ListNode rightSort = sortList(right);

        // 3 merge

        return merge(leftSort,rightSort);

    }

    private static ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // merge Two Sort List

    private static ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        if (l1 != null) {
            temp.next = l1;
        }else{
            temp.next = l2;
        }

        return dummy.next;
    }

        // -------- PRINT LIST --------
    private static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }


    public static void main(String[] args) {
           // Create list: 4->2->1->3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.println("Before Sorting:");
        
         printList(head);
        head = sortList(head);

        System.out.println("After Sorting:");
        printList(head);
    }
}
