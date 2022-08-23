import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class LCA_of_a_Binary_Tree_236 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root.equals(p) || root.equals(q))
			return root;

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left == null) {
			return right;
		} else if (right == null) {
			return left;
		} else {
			return root;
		}
	}

	public TreeNode lowestCommonAncestor_parent_pointers(TreeNode root, TreeNode p, TreeNode q) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		Map<TreeNode, TreeNode> parents = new HashMap<>();

		stack.push(root);
		parents.put(root, null);

		while (!parents.containsKey(p) || !parents.containsKey(q)) {
			TreeNode node = stack.pop();

			if (node.left != null) {
				parents.put(node.left, node);
				stack.push(node.left);
			}

			if (node.right != null) {
				parents.put(node.right, node);
				stack.push(node.right);
			}
		}

		Set<TreeNode> ancestors = new HashSet<>();

		while (p != null) {
			ancestors.add(p);
			p = parents.get(p);
		}

		while (ancestors.contains(q)) {
			q = parents.get(q);
		}

		return q;

	}

}
