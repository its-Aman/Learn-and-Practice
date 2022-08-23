/**
 * @author AmanK
 *
 */
public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 cbt = new Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105();
		System.out.println(cbt.buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 }));
//		System.out.println(cbt.buildTree(new int[] { 1, 2 }, new int[] { 1, 2 }));
	}

	/**
	 * Map<Integer, Integer> map = new HashMap<>(); int pIdx;
	 * 
	 * public TreeNode buildTree(int[] preorder, int[] inorder) { this.pIdx = 0;
	 * 
	 * for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
	 * 
	 * return this.buildTree(preorder, 0, preorder.length - 1); }
	 * 
	 * public TreeNode buildTree(int[] preorder, int left, int right) {
	 * 
	 * if (left > right) return null;
	 * 
	 * int rootVal = preorder[this.pIdx++];
	 * 
	 * return new TreeNode(rootVal, this.buildTree(preorder, left, map.get(rootVal)
	 * - 1), this.buildTree(preorder, map.get(rootVal) + 1, right)); }
	 */

	private int in = 0;
	private int pre = 0;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return build(preorder, inorder, Integer.MIN_VALUE);
	}

	private TreeNode build(int[] preorder, int[] inorder, int stop) {
		if (pre >= preorder.length)
			return null;

		if (inorder[in] == stop) {
			in++;
			return null;
		}

		TreeNode node = new TreeNode(preorder[pre++]);

		node.left = build(preorder, inorder, node.val);
		node.right = build(preorder, inorder, stop);

		return node;
	}
}
