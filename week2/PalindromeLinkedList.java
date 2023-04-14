import java.util.ArrayList;
import java.util.List;


class Solution {
    static class ListNode {
        char val;
        ListNode next;
        ListNode(char x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        // Step 1: Traverse the linked list and store the values in an array
        List<Character> list = new ArrayList<Character>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        // Step 2: Create two pointers to the beginning and end of the array
        int left = 0;
        int right = list.size() - 1;

        // Step 3: Compare the values at both pointers and move them towards each other
        while (left < right) {
            if (list.get(left) != list.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode('a');
        head.next = new ListNode('b');
        head.next.next = new ListNode('c');
        head.next.next.next = new ListNode('b');
        head.next.next.next.next = new ListNode('a');

        Solution solution = new Solution();
        boolean result = solution.isPalindrome(head);

        System.out.println(result); // prints "true"
    }
}
