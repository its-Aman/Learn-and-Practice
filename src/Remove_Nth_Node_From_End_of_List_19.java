/**
 * @author AmanK
 *
 */
public class Remove_Nth_Node_From_End_of_List_19 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode slow = head, fast = head, newHead = new ListNode(-1, head), prev = newHead;

		while (n-- > 0 && fast != null)
			fast = fast.next;

		while (fast != null) {
			prev = slow;
			fast = fast.next;
			slow = slow.next;
		}

		prev.next = slow.next;

		return newHead.next;
	}
}
