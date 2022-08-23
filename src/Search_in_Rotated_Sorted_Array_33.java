public class Search_in_Rotated_Sorted_Array_33 {

	public static void main(String[] args) {
		Search_in_Rotated_Sorted_Array_33 sortedArray = new Search_in_Rotated_Sorted_Array_33();

		System.out.println("searching 8: " + sortedArray.search(new int[] { 6, 7, 8, 9, 0, 1, 2, 3, 4, 5 }, 8));
		System.out.println("searching 6: " + sortedArray.search(new int[] { 6, 7, 8, 9, 0, 1, 2, 3, 4, 5 }, 6));
		System.out.println("searching 4: " + sortedArray.search(new int[] { 6, 7, 8, 9, 0, 1, 2, 3, 4, 5 }, 4));
		System.out.println("searching 0: " + sortedArray.search(new int[] { 6, 7, 8, 9, 0, 1, 2, 3, 4, 5 }, 0));
		System.out.println("searching 3: " + sortedArray.search(new int[] { 6, 7, 8, 9, 0, 1, 2, 3, 4, 5 }, 3));
		System.out.println("searching 3: " + sortedArray.search(new int[] { 6, 7, 8, 9, 0, 1, 2, 3, 4, 5 }, -4));
	}

//	https://www.youtube.com/watch?v=oTfPJKGEHcc

	public int search(int[] nums, int target) {
		int N = nums.length;
		int lo = 0;
		int hi = N - 1;

		while (lo <= hi) {

			int mid = lo + (hi - lo) / 2;

			if (target == nums[mid]) {
				return mid;
			} else if (nums[mid] >= nums[lo]) {
				if (target >= nums[lo] && target <= nums[mid]) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			} else {
				if (target >= nums[mid] && target <= nums[hi]) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}

		}

		return -1;
	}
}

/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
