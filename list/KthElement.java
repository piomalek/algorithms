public class KthElement {

    public static int kthElementFromTail(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        for(int i = 0; i < k; ++i) {
            fast = fast.getNext();
            if(fast == null)
                return -1;
        }

        while(fast.getNext() != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }

        return slow.getVal();
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createList("8,7,6,5,4,3,2,1,0");
        int k = 8;

        System.out.println(String.format("kthElementFromTail(%s, %d) = %d", head, k, kthElementFromTail(head, k)));
    }

}
