public class ListNode {
    private int val;
    private ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode tail(){
        if(next == null) return this;

        ListNode p = next;

        while(p.getNext() != null) {
            p = p.getNext();
        }

        return p;
    }

    public ListNode get(int k) {
        ListNode p = this;
        for(int i = 0; i < k; ++i) {
            p = p.getNext();

            if(p == null) return null;
        }

        return p;
    }

    public static ListNode createList(String s){
        String[] nodes = s.split(",");

        ListNode dummy = new ListNode();
        ListNode p = dummy;
        for(String node : nodes) {
            ListNode next = new ListNode(Integer.valueOf(node.trim()));
            p.setNext(next);
            p = next;
        }

        return dummy.getNext();
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("[" + val);
        ListNode p = next;
        while(p != null) {
            sb.append(", " + p.getVal());
            p = p.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
