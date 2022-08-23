import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author AmanK
 *
 */
public class Find_the_K_Sum_of_an_Array_2386 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Find_the_K_Sum_of_an_Array_2386 ftksoaa = new Find_the_K_Sum_of_an_Array_2386();

		System.out.println(ftksoaa.kSum(new int[] { 2, 4, -2 }, 5));
		System.out.println(ftksoaa.kSum(new int[] { 1, -2, 3, 4, -10, 12 }, 16));
	}

	public long kSum(int[] nums, int K) {
		long sum = 0, minus = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += Math.max(nums[i], 0);
			nums[i] = Math.abs(nums[i]);
		}

		Arrays.sort(nums);

		Queue<long[]> minHeap = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));

		minHeap.offer(new long[] { nums[0], 0 });

		while (--K > 0) {
			long[] top = minHeap.poll();
			long val = top[0];
			int i = (int) top[1];
			minus = val;

			if (i < nums.length - 1) {
				minHeap.offer(new long[] { val - nums[i] + nums[i + 1], i + 1 });
				minHeap.offer(new long[] { val + nums[i + 1], i + 1 });
			}
		}

		return sum - minus;
	}
}
