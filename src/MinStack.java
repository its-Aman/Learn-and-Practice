public class MinStack {
	MinNode head;

	public MinStack() {
	}

	public void push(int val) {
		if (this.head == null) {
			this.head = new MinNode(val, val, null);
		} else {
			this.head = new MinNode(val, Math.min(val, head.min), head);
		}
	}

	public void pop() {
		this.head = this.head.next;
	}

	public int top() {
		return this.head.val;
	}

	public int getMin() {
		return this.head.min;
	}
}
