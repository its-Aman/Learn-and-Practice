/**
 * 
 */

/**
 * @author AmanK
 *
 */
public class Task_Scheduler_621 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Task_Scheduler_621 ts = new Task_Scheduler_621();

		System.out.println(ts.leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2));
	}

	public int leastInterval(char[] tasks, int n) {
		int[] counter = new int[26];
		int max = 0;
		int maxCount = 0;
		int N = tasks.length;

		for (char c : tasks) {
			counter[c - 'A'] += 1;

			if (max == counter[c - 'A'])
				maxCount += 1;

			if (counter[c - 'A'] > max) {
				max = counter[c - 'A'];
				maxCount = 1;
			}
		}

		int partCount = max - 1;
		int partLength = n - (maxCount - 1);
		int emptySlots = partCount * partLength;
		int availableTasks = N - max * maxCount;
		int idles = Math.max(0, emptySlots - availableTasks);

		return N + idles;
	}
}
