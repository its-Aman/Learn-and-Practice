import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.DoubleStream;

/**
 * @author AmanK
 *
 *         You are given an array of variable pairs equations and an array of
 *         real numbers values, where equations[i] = [Ai, Bi] and values[i]
 *         represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string
 *         that represents a single variable.
 * 
 *         You are also given some queries, where queries[j] = [Cj, Dj]
 *         represents the jth query where you must find the answer for Cj / Dj =
 *         ?.
 * 
 *         Return the answers to all queries. If a single answer cannot be
 *         determined, return -1.0.
 * 
 *         Note: The input is always valid. You may assume that evaluating the
 *         queries will not result in division by zero and that there is no
 *         contradiction.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries
 *         = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 
 *         Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000] Explanation:
 *         Given: a / b = 2.0, b / c = 3.0 queries are: a / c = ?, b / a = ?, a
 *         / e = ?, a / a = ?, x / x = ? return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 *         Example 2:
 * 
 *         Input: equations = [["a","b"],["b","c"],["bc","cd"]], values =
 *         [1.5,2.5,5.0], queries =
 *         [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * 
 *         Output: [3.75000,0.40000,5.00000,0.20000]
 * 
 *         Example 3:
 * 
 *         Input: equations = [["a","b"]], values = [0.5], queries =
 *         [["a","b"],["b","a"],["a","c"],["x","y"]]
 * 
 *         Output: [0.50000,2.00000,-1.00000,-1.00000]
 * 
 * 
 *         Constraints:
 * 
 *         1 <= equations.length <= 20 equations[i].length == 2 1 <= Ai.length,
 *         Bi.length <= 5 values.length == equations.length 0.0 < values[i] <=
 *         20.0 1 <= queries.length <= 20 queries[i].length == 2 1 <= Cj.length,
 *         Dj.length <= 5 Ai, Bi, Cj, Dj consist of lower case English letters
 *         and digits.
 */

public class Evaluate_Division_399 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Evaluate_Division_399 ed = new Evaluate_Division_399();
//		List<List<String>> eq = new ArrayList<>();
//		List<List<String>> q = new ArrayList<>();
//		double[] val = new double[] { 1.5, 2.5, 5.0 };
//
//		eq.add(Arrays.asList("a", "b"));
//		eq.add(Arrays.asList("b", "c"));
//		eq.add(Arrays.asList("bc", "cd"));
//
//
//		q.add(Arrays.asList("a", "c"));
//		q.add(Arrays.asList("c", "b"));
//		q.add(Arrays.asList("bc", "cd"));
//		q.add(Arrays.asList("cd", "bc"));
//

//		List<List<String>> eq = new ArrayList<>();
//		List<List<String>> q = new ArrayList<>();
//		double[] val = new double[] { 3.4, 1.4, 2.3 };
//
//		eq.add(Arrays.asList("a", "b"));
//		eq.add(Arrays.asList("e", "f"));
//		eq.add(Arrays.asList("b", "e"));
//
//		q.add(Arrays.asList("b", "a"));
//		q.add(Arrays.asList("a", "f"));
//		q.add(Arrays.asList("f", "f"));
//		q.add(Arrays.asList("e", "e"));
//		q.add(Arrays.asList("c", "c"));
//		q.add(Arrays.asList("a", "c"));
//		q.add(Arrays.asList("f", "e"));

		List<List<String>> eq = new ArrayList<>();
		List<List<String>> q = new ArrayList<>();
		double[] val = new double[] { 3.0, 0.5, 3.4, 5.6 };

		eq.add(Arrays.asList("x1", "x2"));
		eq.add(Arrays.asList("x2", "x3"));
		eq.add(Arrays.asList("x1", "x4"));
		eq.add(Arrays.asList("x2", "x5"));

		q.add(Arrays.asList("x2", "x4"));
		q.add(Arrays.asList("x1", "x5"));
		q.add(Arrays.asList("x1", "x3"));
		q.add(Arrays.asList("x5", "x5"));
		q.add(Arrays.asList("x5", "x1"));
		q.add(Arrays.asList("x3", "x4"));
		q.add(Arrays.asList("x4", "x3"));
		q.add(Arrays.asList("x6", "x6"));
		q.add(Arrays.asList("x0", "x0"));
		DoubleStream.of(ed.calcEquation(eq, val, q)).forEach(System.out::println);
	}

	Map<String, String> root = new HashMap<>();
	Map<String, Double> dist = new HashMap<>();

	private String find(String s) {
		if (!this.root.containsKey(s)) {
			this.root.put(s, s);
			this.dist.put(s, 1.0);
			return s;
		}

		if (this.root.get(s).equals(s)) {
			return s;
		}

//		Path Compression
		String lastParent = this.root.get(s);
		String newParent = this.find(lastParent);

		if (!lastParent.equals(newParent)) {
			this.root.put(s, newParent);
			this.dist.put(s, this.dist.get(s) * this.dist.get(lastParent));
		}

		return newParent;
	}

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		int N = equations.size();
		int M = queries.size();
		double[] ans = new double[M];

		for (int i = 0; i < N; i++) {
			List<String> eq = equations.get(i);

			String x = eq.get(0);
			String y = eq.get(1);

			String xx = this.find(x);
			String yy = this.find(y);

			this.root.put(xx, yy);
			this.dist.put(xx, this.dist.get(y) * values[i] / this.dist.get(x));
		}

		for (int i = 0; i < M; i++) {
			List<String> q = queries.get(i);
			String x = q.get(0);
			String y = q.get(1);

			if (!this.root.containsKey(x) || !this.root.containsKey(y) || !this.find(x).equals(this.find(y))) {
				ans[i] = -1.0;
			} else {
				ans[i] = this.dist.get(x) / this.dist.get(y);
			}

		}

		return ans;
	}

//	public double[] calcEquation(String[][] e, double[] values, String[][] q) {
//	public double[] calcEquation(List<List<String>> e, double[] values, List<List<String>> q) {
//		double[] res = new double[q.size()];
//		Map<String, String> root = new HashMap<>();
//		Map<String, Double> dist = new HashMap<>();
//		for (int i = 0; i < e.size(); i++) {
//			String r1 = find(root, dist, e.get(i).get(0));
//			String r2 = find(root, dist, e.get(i).get(1));
//			root.put(r1, r2);
//			dist.put(r1, dist.get(e.get(i).get(1)) * values[i] / dist.get(e.get(i).get(0)));
//		}
//		for (int i = 0; i < q.size(); i++) {
//			if (!root.containsKey(q.get(i).get(0)) || !root.containsKey(q.get(i).get(1))) {
//				res[i] = -1.0;
//				continue;
//			}
//			String r1 = find(root, dist, q.get(i).get(0));
//			String r2 = find(root, dist, q.get(i).get(1));
//			if (!r1.equals(r2)) {
//				res[i] = -1.0;
//				continue;
//			}
//			res[i] = (double) dist.get(q.get(i).get(0)) / dist.get(q.get(i).get(1));
//		}
//		return res;
//	}
//
//	private String find(Map<String, String> root, Map<String, Double> dist, String s) {
//		if (!root.containsKey(s)) {
//			root.put(s, s);
//			dist.put(s, 1.0);
//			return s;
//		}
//		if (root.get(s).equals(s))
//			return s;
//		String lastP = root.get(s);
//		String p = find(root, dist, lastP);
//		root.put(s, p);
//		dist.put(s, dist.get(s) * dist.get(lastP));
//		return p;
//	}
}
