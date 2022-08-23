/**
 * 
 */

/**
 * @author AmanK
 *
 */
public class Flatten_Binary_Tree_to_Linked_List_114 {

	public void flatten(TreeNode root) {
		TreeNode curr = root;
		TreeNode prev = null;

		while (curr != null) {
			if (curr.left != null) {
				prev = curr.left;

				while (prev.right != null) {
					prev = prev.right;
				}
				
				prev.right = curr.right;
				curr.right = curr.left;
				curr.left = null;
			}

			curr = curr.right;
		}
	}

}
