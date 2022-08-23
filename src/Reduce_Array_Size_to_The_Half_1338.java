/**
 * @author AmanK
 *
 */
public class Reduce_Array_Size_to_The_Half_1338 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Reduce_Array_Size_to_The_Half_1338 rastth = new Reduce_Array_Size_to_The_Half_1338();
		System.out.println(rastth.minSetSize(new int[] { 3, 3, 3, 3, 5, 5, 5, 2, 2, 7 }));
		System.out.println(rastth.minSetSize(new int[] { 7, 7, 7, 7, 7, 7 }));
	}

	public int minSetSize(int[] arr) {

		int N = arr.length, min = 1000000, max = 0;

		for (int val : arr) {
			min = Math.min(val, min);
			max = Math.max(val, max);
		}

		int[] count = new int[max - min + 1];

		for (int val : arr)
			count[val - min] += 1;

		int[] bucket = new int[N + 1];

		for (int cnt : count)
			if (cnt != 0)
				bucket[cnt] += 1;

		int sum = 0, size = 0, half = N >> 1;

		for (int i = N; i > 0; i--) {
			while (bucket[i]-- != 0) {
				sum += i;
				size += 1;

				if (sum >= half)
					return size;
			}
		}

		return -1;
	}
}
