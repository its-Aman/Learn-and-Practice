/**
 * @author AmanK
 *
 */
public class Split_Array_into_Consecutive_Subsequences_659 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Split_Array_into_Consecutive_Subsequences_659 saics = new Split_Array_into_Consecutive_Subsequences_659();

//		System.out.println(saics.isPossible(new int[] { 1, 2, 3, 3, 4, 5 }));
		System.out.println(saics.isPossible(new int[] { 1, 2, 3, 3, 4, 4, 5, 5 }));
//		System.out.println(saics.isPossible(new int[] { 1, 2, 3, 4, 4, 5 }));
//		System.out.println(saics.isPossible(new int[] { 1, 2, 3, 4, 5 }));
//		System.out.println(saics.isPossible(new int[] { 1, 2, 3, 4, 6, 8 }));
//		System.out.println(saics.isPossible(new int[] { 1, 8, 9, 10, 11, 12, 13, 14, 15, 16 }));
	}

	public boolean isPossible(int[] nums) {
		int i = 0, N = nums.length, cnt = 0;
		int prev = Integer.MIN_VALUE, p1 = 0, p2 = 0, p3 = 0;
		int curr = 0, c1 = 0, c2 = 0, c3 = 0;

		while (i < N) {

			curr = nums[i];
			cnt = 0;

			while (i < N && curr == nums[i]) {
				cnt += 1;
				i += 1;
			}

			if (curr == prev + 1) {
				if (cnt < p1 + p2)
					return false;

				c2 = p1;
				c3 = p2;

				c3 += Math.min(p3, cnt - (p1 + p2));
				c1 = Math.max(0, cnt - (p1 + p2 + p3));

			} else {
				if (p1 != 0 || p2 != 0)
					return false;

				c1 = cnt;
				c2 = c3 = 0;
			}

			prev = curr;
			p1 = c1;
			p2 = c2;
			p3 = c3;

		}

		return p1 == 0 && p2 == 0;
	}

}