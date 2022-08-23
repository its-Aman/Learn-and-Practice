import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * @author AmanK
 *
 */
public class Reconstruct_Itinerary_332 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reconstruct_Itinerary_332 ri = new Reconstruct_Itinerary_332();

		List<List<String>> list = new LinkedList<>();

		list.add(Arrays.asList("MUC", "LHR"));
		list.add(Arrays.asList("JFK", "MUC"));
		list.add(Arrays.asList("SFO", "SJC"));
		list.add(Arrays.asList("LHR", "SFO"));

//		["JFK","MUC","LHR","SFO","SJC"]
		System.out.println(ri.findItinerary(list));
		list.clear();

		list.add(Arrays.asList("JFK", "SFO"));
		list.add(Arrays.asList("JFK", "ATL"));
		list.add(Arrays.asList("SFO", "ATL"));
		list.add(Arrays.asList("ATL", "JFK"));
		list.add(Arrays.asList("ATL", "SFO"));

//		["JFK","ATL","JFK","SFO","ATL","SFO"]
		System.out.println(ri.findItinerary(list));
		list.clear();

		list.add(Arrays.asList("JFK", "KUL"));
		list.add(Arrays.asList("JFK", "NRT"));
		list.add(Arrays.asList("NRT", "JFK"));

//		["JFK","NRT","JFK","KUL"]
		System.out.println(ri.findItinerary(list));
	}

	public List<String> findItinerary(List<List<String>> tickets) {
		Map<String, PriorityQueue<String>> targets = new HashMap<>();
		LinkedList<String> route = new LinkedList<String>();
		Stack<String> stack = new Stack<>();

		for (var ticket : tickets)
			targets.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<String>()).add(ticket.get(1));

		stack.push("JFK");

		while (!stack.empty()) {

			while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
				stack.push(targets.get(stack.peek()).poll());

			route.addFirst(stack.pop());
		}

		return route;
	}

	public List<String> findItinerary2(List<List<String>> tickets) {
		Map<String, Queue<String>> graph = new HashMap<>();
		List<String> list = new ArrayList<>();

		for (var ticket : tickets) {
			String from = ticket.get(0);
			String to = ticket.get(1);

			graph.putIfAbsent(from, new PriorityQueue<>());
			graph.get(from).offer(to);
		}

		this.dfs("JFK", graph, list);
		Collections.reverse(list);

		return list;
	}

	private void dfs(String at, Map<String, Queue<String>> graph, List<String> list) {
		Queue<String> pq = graph.get(at);

		while (pq != null && !pq.isEmpty()) {
			String next = pq.poll();
			this.dfs(next, graph, list);
		}

		list.add(at);
	}
}