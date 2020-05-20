package krishna.leetcode.may2020_30day;
/**
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * Example 1:
 * 
 * Input: root = [3,1,4,null,2], k = 1 

 *      3
 *     / \
 *    1   4
 *     \
 *      2
 *
 * Output: 1 
 * 
 * Example 2:
 * 
 * Input: root = [5,3,6,2,4,null,null,1]
 * 
 *          5
 *         / \
 *        3   6
 *       / \
 *      2   4
 *     /
 *    1
 * Output: 3
 * 
 * 
 * @author krishna_k
 *
 */
public class Day20KthSmallestElementInBst {

	/**
	 * Definition for a binary tree node.
	 **/
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
	}

	int kthSmallest = -1;
	int curr = 0;
	int k;

	public int kthSmallest(TreeNode root, int k) {
		kthSmallest = -1;
		curr = 0;
		this.k = k;
		traverse(root);
		return kthSmallest;
	}

	void traverse(TreeNode root) {
		if (root == null) {
			return;
		}

		traverse(root.left);
		if (curr == k) {
			return;
		}
		curr++;
		if (curr == k) {
			kthSmallest = root.val;
			return;
		}
		traverse(root.right);
	}
}
