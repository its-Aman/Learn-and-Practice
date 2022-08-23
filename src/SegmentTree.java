/**
 * 
 * @author AmanK
 *
 */
public class SegmentTree {
	private int N;
	private int[] tree;

	public SegmentTree(int size) {
		this.N = size;
		this.tree = new int[4 * size];
	}

	public static void main(String[] args) {
		SegmentTree sgmtTree = new SegmentTree(3);
		sgmtTree.build(new int[] { 1, 3, 5 });
		System.out.println(sgmtTree.sum(0, 2));
		sgmtTree.update(1, 2);
		System.out.println(sgmtTree.sum(0, 2));
	}

	public void build(int[] arr) {
		this.build(arr, 1, 0, this.N - 1);
	}

	private void build(int[] arr, int vtx, int left, int right) {
		if (left == right) {
			this.tree[vtx] = arr[left];
		} else {
			int mid = left + (right - left) / 2;

			this.build(arr, 2 * vtx, left, mid);
			this.build(arr, 2 * vtx + 1, mid + 1, right);

			this.tree[vtx] = this.tree[2 * vtx] + this.tree[2 * vtx + 1];
		}
	}

	public void update(int idx, int value) {
		this.update(1, 0, this.N - 1, idx, value);
	}

	private void update(int vtx, int left, int right, int idx, int value) {
		if (left == right) {
			this.tree[vtx] = value;
		} else {
			int mid = left + (right - left) / 2;

			if (idx <= mid) {
				this.update(2 * vtx, left, mid, idx, value);
			} else {
				this.update(2 * vtx + 1, mid + 1, right, idx, value);
			}

			this.tree[vtx] = this.tree[2 * vtx] + this.tree[2 * vtx + 1];
		}
	}

	public int sum(int qLeft, int qRight) {
		return this.sum(1, 0, this.N - 1, qLeft, qRight);
	}

	private int sum(int vtx, int left, int right, int qLeft, int qRight) {
		if (qLeft > qRight) {
			return 0;
		}

		if (left == qLeft && right == qRight) {
			return this.tree[vtx];
		} else {
			int mid = left + (right - left) / 2;
			return (this.sum(2 * vtx, left, mid, qLeft, Math.min(qRight, mid))
					+ this.sum(2 * vtx + 1, mid + 1, right, Math.max(qLeft, mid + 1), qRight));
		}
	}
}
