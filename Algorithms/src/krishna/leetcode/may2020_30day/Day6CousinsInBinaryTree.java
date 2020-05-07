package krishna.leetcode.may2020_30day;

/**
 * URL : https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3322/
 * 
 * 
 * In a binary tree, the root node is at depth 0, and children of each depth k
 * node are at depth k+1.
 * 
 * Two nodes of a binary tree are cousins if they have the same depth, but have
 * different parents.
 * 
 * We are given the root of a binary tree with unique values, and the values x
 * and y of two different nodes in the tree.
 * 
 * Return true if and only if the nodes corresponding to the values x and y are
 * cousins.
 * 
 * 
 * 
 * Example 1:
 * 				  1
 * 				/   \
 * 			   2	 3
 * 			/
 *		   4 
 * Input: root = [1,2,3,4], x = 4, y = 3 Output: false 
 * 
 * Example 2:
 *
 * 				  1
 * 				/   \
 * 			   2	 3
 * 				\     \
 * 				 4	   5	
 * 
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4 Output: true 
 * 
 * Example 3:
 * 
 * 				  1
 * 				/   \
 * 			   2	 3
 * 				\     
 * 				 4	   	
 * 
 * 
 * Input: root = [1,2,3,null,4], x = 2, y = 3 Output: false
 * 
 * 
 * Note:
 * 
 * The number of nodes in the tree will be between 2 and 100. Each node has a
 * unique integer value from 1 to 100.
 * 
 * [Current solution beats run time of rest o Java submissions by 100 %.
 * 
 * @author krishna_k
 *
 */
public class Day6CousinsInBinaryTree {

	/**
	 * Definition for a binary tree node.
	 */
	public static class TreeNode {
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

	private class Queue {
		TreeNode[] q = new TreeNode[201];
		int size = 0;
		int headIndex = 0;
		int tailIndex = 0;

		// assumes enqueue is invoked always on a non full queue
		public void enqueue(TreeNode element) {
			q[tailIndex] = element;
			tailIndex++;
			size++;
		}

		// assumes a dequeue is invoked always on non empty queue
		public TreeNode dequeue() {
			TreeNode element = q[headIndex];
			headIndex++;
			size--;
			return element;
		}

		public boolean isEmpty() {
			return size == 0;
		}
	}

	public boolean isCousins(TreeNode root, int x, int y) {
		if (x == y || x == root.val || y == root.val) {
			// if x and y both equal => same parent (same element) so return false
			// if root.val equals any of x or y then there exists no other node at its level
			// so return false
			return false;
		}
		final TreeNode MARKER = new TreeNode(-1); // as per the question the elements can be only between 1 and 100
		Queue q = new Queue();
		q.enqueue(root);
		q.enqueue(MARKER);
		int depth = 0;
		TreeNode foundParentValue = null;
		int foundDepth = -1;
		while (!q.isEmpty()) {
			TreeNode element = q.dequeue();
			if ((element == MARKER)) {
				if (q.isEmpty()) {
					break;
				}
				depth++;
				q.enqueue(MARKER);
			} else {
				TreeNode left = element.left;
				TreeNode right = element.right;

				if (left != null) {
					int leftVal = left.val;
					if (leftVal == x || leftVal == y) {
						if (foundDepth == -1) {
							foundDepth = depth;
							foundParentValue = element;
						} else {
							return ((foundDepth == depth) && (foundParentValue != element));
						}
					}
					q.enqueue(left);
				}
				if (right != null) {
					int rightVal = right.val;
					if (rightVal == x || rightVal == y) {
						if (foundDepth == -1) {
							foundDepth = depth;
							foundParentValue = element;
						} else {
							return ((foundDepth == depth) && (foundParentValue != element));
						}
					}
					q.enqueue(right);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
//		[1,2,3,null,4,null,5]
//				5
//				4
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		root.left = node2;
		root.right = node3;
		node2.right = node4;
		node3.right = node5;
		Day6CousinsInBinaryTree o = new Day6CousinsInBinaryTree();
		boolean result = o.isCousins(root, 5, 4);
		System.out.println(result);
	}
}
