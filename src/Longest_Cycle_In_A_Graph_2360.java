import java.util.*;
import javafx.util.Pair;

/**
 * @author AmanK
 *
 */
public class Longest_Cycle_In_A_Graph_2360 {
	public static void main(String[] args) {
		Longest_Cycle_In_A_Graph_2360 gp = new Longest_Cycle_In_A_Graph_2360();

		System.out.println(gp.longestCycle(new int[] { 3, 3, 4, 2, 3 }));

	}

	public int longestCycle(int[] edges) {
		int res = -1;

		Pair<Integer, Integer>[] memo = new Pair[edges.length];

		Arrays.fill(memo, new Pair<Integer, Integer>(-1, -1));

		for (int i = 0; i < edges.length; i++) {

			for (int j = i, dist = 0; j != -1; j = edges[j]) {
				Pair<Integer, Integer> p = memo[j];

				if (p.getKey() == -1) {
					memo[j] = new Pair<Integer, Integer>(dist++, i);
				} else {
					if (p.getValue() == i) {
						res = Math.max(res, dist - p.getKey());
					}
					break;
				}
			}
		}

		return res;
	}
}
