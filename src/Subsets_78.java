import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author AmanK
 *
 */
public class Subsets_78 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Subsets_78 s = new Subsets_78();

		long start = System.currentTimeMillis();
		System.out.println(s.subsets(new int[] { 1, 2, 3 }));
		System.out.println(System.currentTimeMillis() - start);

		Map<Integer, Integer> dict = new HashMap<>();
		Collections.sort(List.copyOf(dict.values()));
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new LinkedList<>();
		int N = nums.length;

		for (int i = 0; i < Math.pow(2, N); i++) {
			List<Integer> curr = new ArrayList<>();
			int k = i;

			for (int j = 0; j < N; j++) {

				if (k == 0) {
					break;
				}

				if ((k & 1) == 1) {
					curr.add(nums[j]);
				}
				k >>= 1;
			}

			ans.add(curr);
		}

//		this.backtrack(0, new Stack<Integer>(), ans, nums);

		return ans;
	}

	private void backtrack(int idx, Stack<Integer> curr, List<List<Integer>> ans, int[] nums) {
		if (idx > nums.length)
			return;

		ans.add(new LinkedList<>(curr));

		for (int i = idx; i < nums.length; i++) {
			curr.push(nums[i]);
			this.backtrack(i + 1, curr, ans, nums);
			curr.pop();
		}

	}
}