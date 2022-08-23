import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		var list = new ArrayList<String>();

		list.add(Integer.toString(this.val));
		
		if (this.left != null) {
			list.add(this.left.toString());
		}

		if (this.right != null) {
			list.add(this.right.toString());
		}

		return list.toString();
	}
}