public class PalindromeLinkedList {
    private boolean checkVal(ListNode slow, ListNode prev) {
        boolean res = true;
        while (slow != null && prev != null) {
            if (slow.val != prev.val) {
                res = false;
                break;
            }
            slow = slow.next;
            prev = prev.next;
        }
        if (slow != null || prev != null) {
            res = false;
        }
        return res;
    }

    public boolean isPalindrome(ListNode head) {
        boolean res = false;
        if (head == null) { return false; }
        ListNode slow = head;
        ListNode fast = head;

        ListNode prev = null;
        ListNode next = null;
        int ne = 1;
        while(fast != null && fast.next != null) {
            if (fast.next != null) {
                fast = fast.next.next;
                ne = fast != null ? ne + 2 : ne + 1;
            } else {
                fast = null;
            }
            // initialize the next variable
            next = slow.next;
            // reverse the current
            slow.next = prev;
            // initialize the prev variable as current
            prev = slow;
            // proceed to next
            slow = next;
        }
        if (ne % 2 == 0) {
            res = checkVal(slow, prev);
        } else {
            res = checkVal(slow.next, prev);
        }
        return res;
    }
}
