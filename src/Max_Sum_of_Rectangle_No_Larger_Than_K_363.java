import java.util.TreeSet;

/**
 * @author AmanK
 *
 */
public class Max_Sum_of_Rectangle_No_Larger_Than_K_363 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Max_Sum_of_Rectangle_No_Larger_Than_K_363 sol = new Max_Sum_of_Rectangle_No_Larger_Than_K_363();

		System.out.println(sol.maxSumSubmatrix(new int[][] { { 1, 0, 1 }, { 0, -2, 3 } }, 2));
		System.out.println(
				sol.maxSumSubmatrix(new int[][] { { -99, -98, -97 }, { -96, -95, -94 }, { -93, -92, -91 } }, 2));
	}

	public int maxSumSubmatrix(int[][] M, int K) {
		int R = M.length, C = M[0].length, ans = Integer.MIN_VALUE;

		if (C > R) {
			int[][] MM = new int[C][R];

			for (int r = 0; r < R; r++)
				for (int c = 0; c < C; c++)
					MM[c][r] = M[r][c];

			return this.maxSumSubmatrix(MM, K);
		}

		for (int left = 0; left < C; left++) {
			int[] temp = new int[R];

			for (int right = left; right < C; right++) {

				for (int r = 0; r < R; r++)
					temp[r] += M[r][right];

				ans = Math.max(ans, this.maxSumSubArray(temp, K));
			}
		}

		return ans;
	}

	private int maxSumSubArray(int[] nums, int K) {
		TreeSet<Integer> bst = new TreeSet<Integer>();
		int ans = Integer.MIN_VALUE;
		bst.add(0);

		for (int i = 0, right = 0; i < nums.length; i++) {
			right += nums[i];
			Integer left = bst.ceiling(right - K);
			if (left != null)
				ans = Math.max(ans, right - left);
			bst.add(right);
		}

		return ans;
	}

	public int maxSumSubmatrix2(int[][] M, int K) {
		int R = M.length, C = M[0].length, ans = Integer.MIN_VALUE;

		for (int left = 0; left < C; ++left) {
			int[] temp = new int[R]; // arr[i] is sum(matrix[r1][c]...matrix[r2][c])

			for (int right = left; right < C; ++right) {

				for (int r = 0; r < R; ++r)
					temp[r] += M[r][right];

				ans = Math.max(ans, maxSumSubArray2(temp, K));
			}
		}

		return ans;
	}

	private int maxSumSubArray2(int[] nums, int k) { // O(N * logN)
		TreeSet<Integer> bst = new TreeSet<>();
		bst.add(0);

		int ans = Integer.MIN_VALUE;

		for (int i = 0, right = 0; i < nums.length; ++i) {
			right += nums[i];
			Integer left = bst.ceiling(right - k); // right - left <= k -> left >= right - k

			if (left != null)
				ans = Math.max(ans, right - left);

			bst.add(right);
		}

		return ans;
	}

}
