import java.util.*;

public class Binary_Tree_Level_Order_Traversal_102 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();

		if (root == null)
			return ans;

		q.offer(root);

		while (!q.isEmpty()) {
			int N = q.size();
			List<Integer> curr = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				TreeNode node = q.poll();
				curr.add(node.val);
				if (node.left != null)
					q.offer(node.left);

				if (node.right != null)
					q.offer(node.right);
			}
			ans.add(curr);
		}

		return ans;
	}
}
