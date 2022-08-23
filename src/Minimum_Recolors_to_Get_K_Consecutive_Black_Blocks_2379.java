/**
 * @author AmanK
 *
 */
public class Minimum_Recolors_to_Get_K_Consecutive_Black_Blocks_2379 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Minimum_Recolors_to_Get_K_Consecutive_Black_Blocks_2379 sol = new Minimum_Recolors_to_Get_K_Consecutive_Black_Blocks_2379();
		System.out.println(sol.minimumRecolors("WBBWWBBWBW", 7));
		System.out.println(sol.minimumRecolors("WBWBBBW", 2));
	}

	public int minimumRecolors(String blocks, int K) {
		int white = 0, ans = 0;

		for (int i = 0; i < K; i++) {
			if (blocks.charAt(i) == 'W')
				white += 1;
		}

		ans = white;

		for (int i = K; i < blocks.length(); i++) {
			if (blocks.charAt(i - K) == 'W')
				white -= 1;

			if (blocks.charAt(i) == 'W')
				white += 1;

			ans = Math.min(ans, white);
		}

		return ans;
	}
}
