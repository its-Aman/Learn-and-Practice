import java.util.Arrays;

/**
 * @author AmanK
 *
 */
public class Longest_Increasing_Subsequence_300 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Longest_Increasing_Subsequence_300 lis = new Longest_Increasing_Subsequence_300();

		System.out.println(lis.lengthOfLIS(new int[] { 4, 10, 4, 3, 8, 9 }));
	}

	public int lengthOfLIS(int[] nums) {
		int N = nums.length;
		var list = new int[N];
		var idx = 0;

		for (int num : nums) {
			if (idx == 0 || list[idx - 1] < num) {
				list[idx++] = num;
				continue;
			}

			int j = this.binarySearch_LowerBound(list, idx - 1, num);
			list[j] = num;
		}

		return idx;
	}

	private int binarySearch_LowerBound(int[] list, int hi, int num) {
		int lo = 0;

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;

			if (num <= list[mid]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}

		return lo;
	}

	int[] dp;

	public int lengthOfLIS_Recursive(int[] nums) {
		this.dp = new int[1 + nums.length];
		Arrays.fill(dp, -1);
		return this.solve(nums, 0, -1);
	}

	private int solve(int[] nums, int idx, int prev_i) {
		if (idx >= nums.length)
			return 0;
		if (this.dp[prev_i + 1] != -1)
			return this.dp[prev_i + 1];
		int take = 0;
		int dontTake = this.solve(nums, idx + 1, prev_i);
		if (prev_i == -1 || nums[idx] > nums[prev_i])
			take = 1 + this.solve(nums, idx + 1, idx);
		return this.dp[prev_i + 1] = Math.max(take, dontTake);
	}

	public int lengthOfLIS_dp(int[] nums) {
		int N = nums.length;
		int[] dp = new int[1 + nums.length];
		Arrays.fill(dp, 1);
		int ans = 1;

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < i; j++) {

				if (nums[i] > nums[j]) {
					dp[i] = Math.max(1 + dp[j], dp[i]);

					ans = Math.max(ans, dp[i]);
				}

			}

		}

		return ans;
	}
}
