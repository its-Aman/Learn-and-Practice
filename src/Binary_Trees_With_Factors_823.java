import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author AmanK
 *
 */
public class Binary_Trees_With_Factors_823 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Binary_Trees_With_Factors_823 fac = new Binary_Trees_With_Factors_823();

//		System.out.println("ans: " + fac.numFactoredBinaryTrees(new int[] { 2 }));
//		System.out.println("ans: " + fac.numFactoredBinaryTrees(new int[] { 2, 4 }));
//		System.out.println("ans: " + fac.numFactoredBinaryTrees(new int[] { 2, 4, 5, 10 }));
//		System.out.println("ans: " + fac.numFactoredBinaryTrees(new int[] { 2, 4, 5, 10, 20 }));
		System.out.println("ans: " + fac.numFactoredBinaryTrees(new int[] { 18, 3, 6, 2 }));
	}

	public int numFactoredBinaryTrees(int[] arr) {
		long MOD = 7 + (long) Math.pow(10, 9);
		int N = arr.length;
		long[] dp = new long[N];
		Map<Integer, Integer> map = new HashMap<>();
		long ans = 0;

		Arrays.sort(arr);
		Arrays.fill(dp, 1);

		for (int i = 0; i < N; i++)
			map.put(arr[i], i);

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < i; j++) {

				if (arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j])) {
					dp[i] = (dp[i] + dp[j] * dp[map.get(arr[i] / arr[j])]) % MOD;
				}

			}

			ans += dp[i] % MOD;
		}

		return (int) (ans % MOD);
	}
}
