import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author AmanK
 *
 */
public class City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance {

	private int[] parents;

	public static void main(String[] args) {
		City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance c = new City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance();

		List<List<Integer>> list = new ArrayList<>();
		list.add(List.of(0, 1, 3));
		list.add(List.of(1, 2, 1));
		list.add(List.of(1, 3, 4));
		list.add(List.of(2, 3, 1));

		System.out.println(list);

		System.out.println(c.findCity(4, 4, list, 4));
		IntStream.of(c.parents).forEach(System.out::println);
	}

	public int findCity(int N, int M, List<List<Integer>> edges, int distanceThreshold) {
		int ans = 0;
		int[] weightSum = new int[N];

		this.buildUnionFind(N + 1);

		Collections.sort(edges, (List<Integer> a, List<Integer> b) -> a.get(2) - b.get(2));

		for (List<Integer> list : edges) {
			int from = list.get(0);
			int to = list.get(1);
			int weight = list.get(2);

			if (weightSum[from] + weight <= distanceThreshold && this.union(from, to)) {
				weightSum[from] += weight;
				ans = Math.max(ans, from);
			}
		}

		return ans;
	}

	private void buildUnionFind(int N) {
		this.parents = new int[N];

		for (int i = 0; i < this.parents.length; i++) {
			this.parents[i] = i;
		}
	}

	private int find(int x) {
		int temp = x;

		while (temp != this.parents[temp]) {
			temp = this.parents[temp];
		}

		while (x != temp) {
			int next = this.parents[x];
			this.parents[x] = temp;
			x = next;
		}

		return temp;
	}

	private boolean union(int x, int y) {
		int xx = this.find(x);
		int yy = this.find(y);

		if (xx == yy) {
			return false;
		} else {
			this.parents[xx] = yy;
			return true;
		}
	}
}
