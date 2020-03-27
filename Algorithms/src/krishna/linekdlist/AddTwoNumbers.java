package krishna.linekdlist;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 +
 * 465 = 807
 * 
 * @author krishna_ksumars
 *
 */
public class AddTwoNumbers {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode crawl1 = l1;
		ListNode crawl2 = l2;
		int carry = 0;
		ListNode resultRoot = null;
		ListNode crawl3 = null;
		while(crawl1 != null && crawl2 != null) {
			int sum = crawl1.val + crawl2.val + carry;
			carry = sum/10;
			sum = sum % 10;
			ListNode currentNode = new ListNode(sum);
			if(resultRoot == null) {
				resultRoot = currentNode;
				crawl3 = resultRoot;
			}else {
				crawl3.next = currentNode;
				crawl3 = crawl3.next;
			}
			crawl1 = crawl1.next;
			crawl2 = crawl2.next;
		}
		while(crawl1 != null) {
			int sum = crawl1.val + carry;
			carry = sum/10;
			sum = sum % 10;
			ListNode currentNode = new ListNode(sum);
			if(resultRoot == null) {
				resultRoot = currentNode;
				crawl3 = resultRoot;
			}else {
				crawl3.next = currentNode;
				crawl3 = crawl3.next;
			}
			crawl1 = crawl1.next;
		}
		while(crawl2 != null) {
			int sum = crawl2.val + carry;
			carry = sum/10;
			sum = sum % 10;
			ListNode currentNode = new ListNode(sum);
			if(resultRoot == null) {
				resultRoot = currentNode;
				crawl3 = resultRoot;
			}else {
				crawl3.next = currentNode;
				crawl3 = crawl3.next;
			}
			crawl2 = crawl2.next;
		}
		if(carry > 0) {
			ListNode currentNode = new ListNode(carry);
			crawl3.next = currentNode;
		}
		return resultRoot;
	}
}
