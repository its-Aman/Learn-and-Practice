import java.util.stream.IntStream;

/**
 * @author AmanK
 *
 */
public class BinaryIndexedTree {

//	to get to the next sibling -> x = x + (x & -x)
//	to get to the parent -> x = x - (x & -x)

	private int N;
	private int[] BIT;
	private int[] originalArr;

	public static void main(String[] args) {
//		int[] arr = new int[] { 3, 2, -1, 6, 5, 4, -3, 3, 7, 2, 3 };
//		int[] arr = new int[] { 1, 3, 5 };
		int[] arr = new int[] { 7, 2, 7, 2, 0 };

		BinaryIndexedTree bit = new BinaryIndexedTree(arr);
		IntStream.of(bit.BIT).forEach(x -> System.out.println(x));

		bit.update(4, 6);
		bit.update(0, 2);
		bit.update(0, 9);

		System.out.println("update(4, 6) -> update(0, 2) -> update(0, 9)");
		IntStream.of(bit.BIT).forEach(x -> System.out.println(x));

		System.out.println(" sum(4, 4) ->" + (bit.query(4) - bit.query(4 - 1)));

		bit.update(3, 8);
		System.out.println("update(3, 8)");
		IntStream.of(bit.BIT).forEach(x -> System.out.println(x));

		System.out.println(" sum(0, 4) ->" + (bit.query(4)));

		bit.update(4, 1);
		System.out.println("update(4, 1)");
		IntStream.of(bit.BIT).forEach(x -> System.out.println(x));

		System.out.println(" sum(0, 3) ->" + (bit.query(3)));

		System.out.println(" sum(0, 4) ->" + (bit.query(4)));

		bit.update(0, 4);
		System.out.println("update(0, 4)");
		IntStream.of(bit.BIT).forEach(x -> System.out.println(x));
	}

	public BinaryIndexedTree(int[] arr) {
		this.N = arr.length;
		this.BIT = new int[this.N + 1];
		this.originalArr = arr;

		this.buildTree();
	}

	public void update(int idx, int value) {
		int delta = value - this.originalArr[idx];
		this.originalArr[idx] = value;
		int x = idx + 1;

		while (x <= this.N) {
			this.BIT[x] += delta;
			x += x & -x;
		}
	}

	public int query(int idx) {
		int ans = 0;

		int x = idx + 1;

		while (x > 0) {
			ans += this.BIT[x];
			x -= x & -x;
		}

		return ans;
	}

	private void buildTree() {

		for (int i = 0; i < this.N; i++) {
			int x = i + 1;

			while (x <= this.N) {
				this.BIT[x] += this.originalArr[i];
				x += x & -x;
			}
		}
	}

}
