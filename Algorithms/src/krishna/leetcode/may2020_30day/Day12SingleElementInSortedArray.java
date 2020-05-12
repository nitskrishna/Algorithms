package krishna.leetcode.may2020_30day;

/**
 * URL :
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3327/
 * 
 * You are given a sorted array consisting of only integers where every element
 * appears exactly twice, except for one element which appears exactly once.
 * Find this single element that appears only once.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [1,1,2,3,3,4,4,8,8] Output: 2 Example 2:
 * 
 * Input: [3,3,7,7,10,11,11] Output: 10
 * 
 * 
 * Note: Your solution should run in O(log n) time and O(1) space.
 * 
 * @author acer
 *
 */
public class Day12SingleElementInSortedArray {
	public int singleNonDuplicate(int[] nums) {
		// a check can be made on nums.length if it is even then such element does not
		// exists. But as per the question, it is assumed that the element always
		// exists, as in the question what to return in case no such element exists is
		// not mentioned.
		int s = 0;
		int e = nums.length - 1;
		int answer = nums[0]; // initialize to any value as it is guaranteed to find a valid element.
		while (s <= e) {
			int mid = s + (e - s) / 2;
			if (mid == nums.length - 1 || mid == 0) {
				answer = nums[mid];
				break;
			}
			if (mid % 2 == 0) {
				if (nums[mid] == nums[mid + 1]) {
					s = mid + 1;
				} else if (nums[mid] == nums[mid - 1]) {
					e = mid - 1;
				} else {
					answer = nums[mid];
					break;
				}
			} else {
				if (nums[mid] == nums[mid - 1]) {
					s = mid + 1;
				} else if (nums[mid] == nums[mid + 1]) {
					e = mid - 1;
				} else {
					answer = nums[mid];
					break;
				}
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		Day12SingleElementInSortedArray o = new Day12SingleElementInSortedArray();
		int[] arr = {1,1,2,3,3,4,4,8,8};
		int result = o.singleNonDuplicate(arr); 
		System.out.println(result);
	}

}
