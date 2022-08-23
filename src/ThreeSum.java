import java.util.*;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { -1, 0, 1, 2, -1, -4 };

		ThreeSum threeSum = new ThreeSum();

		List<List<Integer>> ans = threeSum.findThreeSum(nums);

		for (List<Integer> l : ans) {
			System.out.println(l);
		}

	}


	public List<List<Integer>> findThreeSum(int[] nums) {
		int N = nums.length;

		HashMap<List<Integer>, List<Integer>> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();

		Arrays.sort(nums);

		for (int i = 0; i < N; i++) {
			int a = nums[i];

			if (a > 0)
				continue;

			set.clear();

			for (int j = 1 + i; j < N; j++) {
				int b = nums[j];

				if (set.contains(-(a + b))) {
					int c = -(a + b);
					map.put(Arrays.asList(a, b, c), Arrays.asList(a, b, c));
				}

				set.add(b);
			}

		}
		
		List<List<Integer>> ans = new LinkedList<>();
		
		for(Map.Entry<List<Integer>, List<Integer>> e: map.entrySet()) {
			ans.add(e.getValue());
		}

		return ans;
	}
}
