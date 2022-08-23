import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author AmanK
 *
 */
public class Partition_Equal_Subset_Sum_416 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Partition_Equal_Subset_Sum_416 pes = new Partition_Equal_Subset_Sum_416();
		long start = System.currentTimeMillis();

//		System.out.println(pes.canPartition_BigInt(new int[] { 23, 13, 11, 7, 6, 5, 5 }));
//		System.out.println(pes.canPartition_BigInt(new int[] { 100, 100, 100, 100, 100, 100, 100, 100 }));
		System.out.println(pes.canPartition_BigInt(new int[] { 2, 2, 3, 5 }));
//		System.out.println(pes.canPartition_BigInt(new int[] { 1, 2, 3, 5 }));
//		System.out.println(pes.canPartition_BigInt(new int[] { 14, 9, 8, 4, 3, 2 }));
//		System.out.println(pes.canPartition_BigInt(new int[] { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
//				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
//				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
//				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
//				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
//				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
//				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
//				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
//				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
//				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99,
//				97 }));

		System.out.println(System.currentTimeMillis() - start);

	}

	public boolean canPartition_bitmask(int[] nums) {
		int sum = 0;
		for (int num : nums)
			sum += num;

		if ((sum & 1) == 1)
			return false;

		long bit = 1;
		bit = bit << (sum >> 1);

		for (int num : nums)
			bit |= bit >> num;

		return (bit & 1) == 1;
	}

	public boolean canPartition_BigInt(int[] nums) throws IOException {
		int sum = 0;
		for (int num : nums)
			sum += num;

		if ((sum & 1) == 1)
			return false;

		System.out.println("Sum: " + sum + "\tHalf: " + (sum >> 1));
		String one = "1";
		BigInteger bit = new BigInteger(one).shiftLeft(sum >> 1);

		for (int num : nums) {
			System.out.println(bit.toString(2));
			bit = bit.or(bit.shiftRight(num));
		}

		System.out.println("bitCount: " + bit.bitCount() + "\t bitLength: " + bit.bitLength());
//		return bit.and(new BigInteger(one)).equals(new BigInteger(one));
		return bit.testBit(0);
	}

	public boolean canPartition_Knapsack(int[] nums) {
		int sum = IntStream.of(nums).reduce((int left, int right) -> left + right).getAsInt();

		if (sum % 2 != 0)
			return false;

		int N = nums.length;
		int target = sum / 2;

//		boolean[] prev = new boolean[target + 1];
//		boolean[] curr = new boolean[target + 1];
//
//		prev[0] = true;

		boolean[] knapsack = new boolean[target + 1];
		knapsack[0] = true;

		for (int i = 1; i <= N; i++) {

			for (int j = target; j >= 0; j--) {

				if (j - nums[i - 1] >= 0) {
					knapsack[j] = knapsack[j] || knapsack[j - nums[i - 1]];
				}

			}

		}

		return knapsack[target];
	}

	public boolean canPartition(int[] nums) {

//		since Sum(S1) = Sum(S2)
//		----> Sum(S1) + Sum(S1) = Sum(S2) + Sum(S1)
//		----> 2 * Sum(S1) = Sum(S)
//		----> Sum(S1) = Sum(S) / 2

		int sum = IntStream.of(nums).reduce((int left, int right) -> left + right).getAsInt();
		int target = sum / 2;

		if (sum % 2 != 0)
			return false;

//		sort the nums
		Arrays.sort(nums);

//		reverse the nums so that it becomes reverse sort
		for (int i = 0; i < nums.length / 2; i++) {
			int temp = nums[i];
			nums[i] = nums[nums.length - 1 - i];
			nums[nums.length - 1 - i] = temp;
		}

//		Set<Integer> set = new HashSet<>();
//		set.add(0);
//
//		for (int num : nums) {
//			var list = new LinkedList<>(set);
//
//			for (int possibleSum : list) {
//				set.add(num + possibleSum);
//
//				if (set.contains(target))
//					return true;
//			}
//		}
//
//		return false;

		return this.backtrack(sum, target, 0, nums);
	}

	private boolean backtrack(int currSum, int target, int currIdx, int[] nums) {
		if (currIdx >= nums.length || currSum < target)
			return false;

		if (currSum == target)
			return true;

		boolean take = this.backtrack(currSum - nums[currIdx], target, currIdx + 1, nums);
		boolean dontTake = this.backtrack(currSum, target, currIdx + 1, nums);

		return take || dontTake;
	}
}
