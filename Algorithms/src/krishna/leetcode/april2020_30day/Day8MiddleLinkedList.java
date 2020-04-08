package krishna.leetcode.april2020_30day;

/**
 * Given a non-empty, singly linked list with head node head, return a middle
 * node of linked list.
 * 
 * If there are two middle nodes, return the second middle node.
 * 
 * Input: [1,2,3,4,5] Output: Node 3 from this list (Serialization: [3,4,5]) The
 * returned node has value 3. (The judge's serialization of this node is
 * [3,4,5]). Note that we returned a ListNode object ans, such that: ans.val =
 * 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * 
 * Input: [1,2,3,4,5,6] Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second
 * one.
 * 
 * The number of nodes in the given list will be between 1 and 100.
 * 
 * @author krishna_kumar
 *
 */
public class Day8MiddleLinkedList {
	/**
	 * Definition for singly-linked list.
	 **/
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode middleNode(ListNode head) {
		ListNode slow  = head;
		ListNode fast = head;
		while(true) {
			if(fast == null || fast.next == null) {
				return slow;
			}
			slow = slow.next;
			fast = fast.next;
			fast = fast.next;
		}
	}

}
 