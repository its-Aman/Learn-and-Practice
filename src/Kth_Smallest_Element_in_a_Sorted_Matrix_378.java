/**
 * @author AmanK
 *
 */
public class Kth_Smallest_Element_in_a_Sorted_Matrix_378 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kth_Smallest_Element_in_a_Sorted_Matrix_378 sm = new Kth_Smallest_Element_in_a_Sorted_Matrix_378();

//		System.out.println(sm.upper_bound(new int[] { 1, 2, 3, 4, 4, 4, 5, 7, 8 }, 2));

		System.out.println(sm.kthSmallest(new int[][] { { 1, 5, 9 }, { 11, 11, 11 }, { 12, 13, 15 } }, 7));
		System.out.println(sm.kthSmallest(new int[][] { { -5 } }, 1));
		System.out.println(sm.kthSmallest(new int[][] { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } }, 8));
	}

	public int kthSmallest(int[][] matrix, int K) {
		int N = matrix.length;
		int lo = matrix[0][0];
		int hi = matrix[N - 1][N - 1];

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			int cnt = 0;

			for (int i = 0; i < N; i++) {
				int ub = this.upper_bound(matrix[i], mid);
				if(ub == 0)
					break;
				cnt += ub;
			}

			if (cnt < K)
				lo = 1 + mid;
			else
				hi = mid;
		}

		return lo;
	}

	private int upper_bound(int[] arr, int K) {
		int lo = 0;
		int hi = arr.length;

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;

			if (arr[mid] <= K)
				lo = mid + 1;
			else
				hi = mid;
		}

		return lo;
	}
}
