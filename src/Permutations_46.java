import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author AmanK
 *
 */
public class Permutations_46 {
	public static void main(String[] args) {
		Permutations_46 p = new Permutations_46();

		System.out.println(p.permute(new int[] { 1, 2, 3 }));
		System.out.println(p.permute(new int[] { 0, 1 }));
		System.out.println(p.permute(new int[] { 1 }));

	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new LinkedList<>();
		boolean[] used = new boolean[nums.length];

		this.backtrack(nums, ans, new ArrayList<>(), used);

		return ans;

	}

	private void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> curr, boolean[] used) {

		if (curr.size() == nums.length) {
			ans.add(List.copyOf(curr));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (used[i])
				continue;

			used[i] = true;
			curr.add(nums[i]);
			this.backtrack(nums, ans, curr, used);
			curr.remove(curr.size() - 1);
			used[i] = false;
		}

	}
}
