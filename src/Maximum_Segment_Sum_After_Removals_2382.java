import java.util.Arrays;
import java.util.stream.LongStream;

/**
 * @author AmanK
 *
 */
public class Maximum_Segment_Sum_After_Removals_2382 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Maximum_Segment_Sum_After_Removals_2382 sol = new Maximum_Segment_Sum_After_Removals_2382();
//		LongStream.of(sol.maximumSegmentSum(new int[] { 1, 2, 5, 6, 1 }, new int[] { 0, 3, 2, 4, 1 }))
//				.forEach(System.out::println);
//
//		LongStream.of(sol.maximumSegmentSum(new int[] { 3, 2, 11, 1 }, new int[] { 3, 2, 1, 0 }))
//				.forEach(System.out::println);

		LongStream.of(sol.maximumSegmentSum(new int[] { 500, 822, 202, 707, 298, 484, 311, 680, 901, 319, 343, 340 },
				new int[] { 6, 4, 0, 5, 2, 3, 10, 8, 7, 9, 1, 11 })).forEach(System.out::println);

	}

	private long[] ds;

	public long[] maximumSegmentSum(int[] nums, int[] rq) {
		int N = nums.length;
		long[] ans = new long[N];
		ds = new long[N];

		Arrays.fill(ds, Integer.MAX_VALUE);

		for (int i = rq.length - 1; i > 0; --i) {
			int j = rq[i];

			ds[j] = -nums[j];

			if (j > 0 && ds[j - 1] != Integer.MAX_VALUE)
				this.merge(j, j - 1);

			if (j < N - 1 && ds[j + 1] != Integer.MAX_VALUE)
				this.merge(j, j + 1);

			ans[i - 1] = Math.max(ans[i], -ds[this.find(j)]);
		}

		return ans;
	}

	private void merge(int i, int j) {
		int ii = this.find(i);
		int jj = this.find(j);

		this.ds[jj] += this.ds[ii];
		this.ds[ii] = jj;
	}

	private int find(int i) {

		if (this.ds[i] < 0)
			return i;
		else
			return (int) (this.ds[i] = this.find((int) this.ds[i]));
	}

}
