import java.util.Arrays;

public class Coin_Change_322 {

	public static void main(String[] args) {
		Coin_Change_322 cs = new Coin_Change_322();
		System.out.println(cs.coinChange(new int[] { 1, 2, 5 }, 11));
		System.out.println(cs.coinChange(new int[] { 2 }, 3));
		System.out.println(cs.coinChange(new int[] { 1 }, 0));
	}

	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[1 + amount];

		Arrays.fill(dp, 1 + amount);

		dp[0] = 0;

		for (int i = 1; i <= amount; i++) {

			for (int coin : coins) {
				if (coin > i)
					continue;

				dp[i] = Math.min(1 + dp[i - coin], dp[i]);
			}
		}

		return dp[amount] > amount ? -1 : dp[amount];
	}

}
