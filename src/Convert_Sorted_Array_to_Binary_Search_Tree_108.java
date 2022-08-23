/**
 * @author AmanK
 *
 */
public class Convert_Sorted_Array_to_Binary_Search_Tree_108 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Convert_Sorted_Array_to_Binary_Search_Tree_108 sa2bst = new Convert_Sorted_Array_to_Binary_Search_Tree_108();

		System.out.println(sa2bst.sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 }));

	}

	public TreeNode sortedArrayToBST(int[] nums) {
//		System.out.println("nums are: ");
//		IntStream.of(nums).forEach(System.out::println);
//		Thread.sleep(1000);

//		if (nums.length == 0)
//			return null;
//
//		return new TreeNode(nums[nums.length / 2], this.sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2)),
//				this.sortedArrayToBST(Arrays.copyOfRange(nums, 1 + (nums.length / 2), nums.length)));

		return this.sortedArrayToBST(nums, 0, nums.length - 1);

	}

	public TreeNode sortedArrayToBST(int[] nums, int low, int hi) {
		if (low > hi)
			return null;

		int mid = low + (hi - low) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = this.sortedArrayToBST(nums, low, mid - 1);
		node.right = this.sortedArrayToBST(nums, mid + 1, hi);

		return node;
	}
}
