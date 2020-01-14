// https://leetcode.com/problems/linked-list-cycle-ii/
public class CycleDetection {

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast) {
                break;
            }
        }

        if(fast == slow) {
            slow = head;

            while(slow != fast){
                slow = slow.getNext();
                fast = fast.getNext();
            }

            return slow;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createList("0,1,2,3,4,5,6,7");

        System.out.println("Given list: " + head);
        System.out.println("Cycle does not exist: " + (detectCycle(head) == null));

        // create cycle
        ListNode tail = head.tail();
        int k = 3;
        ListNode kTh = head.get(k);
        tail.setNext(kTh);

        System.out.println(String.format("Connecting tail (%d) with kth node (%d)", tail.getVal(), kTh.getVal()));
        System.out.println("Cycle does exist at element: " + detectCycle(head).getVal());
    }
}
