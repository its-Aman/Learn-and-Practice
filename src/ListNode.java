/**
 * @author AmanK
 *
 */

/**
 * Definition for singly-linked list.
 */
public class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		if (this.next != null)
			return " -> ".concat(Integer.toString(this.val)).concat(this.next.toString());
		else
			return " -> ".concat(Integer.toString(this.val));
	}
}
