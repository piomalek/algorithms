// https://leetcode.com/problems/reverse-linked-list/
public class ReverseList {

    public static ListNode reverseListIterative(ListNode head) {
        if(head == null) return null;

        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            ListNode next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.getNext() == null) return head;
        ListNode p = reverseListRecursive(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return p;
    }

    public static void main(String[] args) {
        String list = "1,2,3,4,5,6";
        ListNode listA = ListNode.createList(list);
        ListNode listB = ListNode.createList(list);

        System.out.println(String.format("reverseListIterative(%s) = %s", list, reverseListIterative(listA)));
        System.out.println(String.format("reverseListRecursive(%s) = %s", list, reverseListRecursive(listB)));
    }
}
