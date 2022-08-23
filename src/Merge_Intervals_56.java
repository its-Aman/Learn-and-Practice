import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author AmanK
 *
 */
public class Merge_Intervals_56 {

	public static void main(String[] args) {
		Merge_Intervals_56 mi = new Merge_Intervals_56();
//		Stream.of(mi.merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } }))
//				.map(interval -> Arrays.toString(interval)).forEach(System.out::println);

		Stream.of(mi.merge(new int[][] { { 2, 3 }, { 4, 5 }, { 6, 7 }, { 8, 9 }, { 1, 10 } }))
				.map(interval -> Arrays.toString(interval)).forEach(System.out::println);

	}

	public int[][] merge(int[][] intervals) {
		int N = intervals.length;

		ArrayList<int[]> mergeIntervals = new ArrayList<>();

		Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

		for (int i = 1; i <= N; i++) {
			int start = intervals[i - 1][0];
			int end = intervals[i - 1][1];

			while (i < N && (start <= intervals[i][0] && intervals[i][0] <= end)) {
				end = Math.max(end, intervals[i][1]);
				i += 1;
			}

			mergeIntervals.add(new int[] { start, end });
		}

		return mergeIntervals.toArray(new int[0][]);
	}

}
