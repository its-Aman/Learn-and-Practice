
/**
 * 
 */

import java.util.*;

/**
 * @author AmanK
 *
 */
public class Clone_Graph_133 {

	public Node cloneGraph(Node node) {
		if (node == null)
			return null;

		Node copy = new Node(node.val);

		Node[] seen = new Node[101];
		Arrays.fill(seen, null);

		cloneGraph(node, copy, seen);

		return copy;
	}

	public void cloneGraph(Node node, Node copy, Node[] seen) {
		seen[copy.val] = copy;

		for (Node n : node.neighbors) {
			if (seen[n.val] != null) {
				copy.neighbors.add(seen[n.val]);
			} else {
				Node newCopy = new Node(n.val);
				copy.neighbors.add(newCopy);
				cloneGraph(n, newCopy, seen);
			}
		}
	}

}
