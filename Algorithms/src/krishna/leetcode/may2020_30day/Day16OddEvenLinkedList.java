package krishna.leetcode.may2020_30day;

/**
 * Given a singly linked list, group all odd nodes together followed by the even
 * nodes. Please note here we are talking about the node number and not the
 * value in the nodes.
 * 
 * You should try to do it in place. The program should run in O(1) space
 * complexity and O(nodes) time complexity.
 * 
 * Example 1:
 * 
 * Input: 1->2->3->4->5->NULL Output: 1->3->5->2->4->NULL Example 2:
 * 
 * Input: 2->1->3->5->6->4->7->NULL Output: 2->3->6->7->1->5->4->NULL
 * 
 * Note:
 * 
 * The relative order inside both the even and odd groups should remain as it
 * was in the input. The first node is considered odd, the second node even and
 * so on ...
 * 
 * @author krishna_k
 *
 */
public class Day16OddEvenLinkedList {
	/**
	 * Definition for singly-linked list.
	 */
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}
		ListNode firstEvenNode = null;
		ListNode secondEvenNode = null;
		ListNode curr = head;
		ListNode nextEvenNode = null;
		ListNode nextOddNode = null;
		ListNode lastNode = null;
		while (curr != null) {
			lastNode = curr;
			curr = curr.next;
		}
		curr = head;
		while (curr != null) {
			nextEvenNode = curr.next;
			if (nextEvenNode != null) {
				if (nextEvenNode == firstEvenNode || nextEvenNode == secondEvenNode) {
					break;
				}
				if (firstEvenNode == null) {
					firstEvenNode = nextEvenNode;
				} else if (secondEvenNode == null) {
					secondEvenNode = nextEvenNode;
				}
				nextOddNode = nextEvenNode.next;
				curr.next = nextOddNode;
				nextEvenNode.next = null;
				lastNode.next = nextEvenNode;
				lastNode = nextEvenNode;
				curr = nextOddNode;
			}
		}
		return head;
	}
}