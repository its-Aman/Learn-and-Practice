
/**
 * 
 */

import java.util.*;

/**
 * @author AmanK
 *
 */
public class Clone_Graph_133 {

	public QNode cloneGraph(QNode node) {
		if (node == null)
			return null;

		QNode copy = new QNode(node.val);

		QNode[] seen = new QNode[101];
		Arrays.fill(seen, null);

		cloneGraph(node, copy, seen);

		return copy;
	}

	public void cloneGraph(QNode node, QNode copy, QNode[] seen) {
		seen[copy.val] = copy;

		for (QNode n : node.neighbors) {
			if (seen[n.val] != null) {
				copy.neighbors.add(seen[n.val]);
			} else {
				QNode newCopy = new QNode(n.val);
				copy.neighbors.add(newCopy);
				cloneGraph(n, newCopy, seen);
			}
		}
	}

}
