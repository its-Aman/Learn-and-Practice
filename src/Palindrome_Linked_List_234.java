/**
 * 
 */

/**
 * @author AmanK
 *
 */
public class Palindrome_Linked_List_234 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Palindrome_Linked_List_234 pll = new Palindrome_Linked_List_234();

		ListNode head = new ListNode();
		ListNode curr = head;

		for (int val : new int[] { 1, 2, 2, 1 }) {
			curr.next = new ListNode(val);
			curr = curr.next;
		}

		System.out.println(pll.isPalindrome(head.next));
	}

	public boolean isPalindrome(ListNode head) {
		ListNode slow = head, fast = head, prev = null;

		while (fast != null) {
			ListNode temp = slow;
			slow = slow.next;

			if (fast.next != null)
				fast = fast.next.next;
			else
				break;
			
			temp.next = prev;
			prev = temp;
		}

		System.out.println(slow);
		System.out.println(prev);

		while (slow != null) {
			if (slow.val != prev.val)
				return false;
			slow = slow.next;
			prev = prev.next;
		}

		return true;
	}
}
