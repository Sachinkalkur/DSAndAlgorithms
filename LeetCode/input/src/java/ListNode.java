public class ListNode {
    int val;
    ListNode next;
    public ListNode(int val, ListNode next) {
        this.next = next;
        this.val = val;
    }
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
