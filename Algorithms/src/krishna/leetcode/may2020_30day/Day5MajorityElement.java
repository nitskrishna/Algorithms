package krishna.leetcode.may2020_30day;

import java.util.HashMap;
import java.util.Map;

/**
 * URL :
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3321/
 * 
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example 1:
 * 
 * Input: [3,2,3] Output: 3 Example 2:
 * 
 * Input: [2,2,1,1,1,2,2] Output: 2
 * 
 * @author krishna_k
 *
 */
public class Day5MajorityElement {
	// Using Moore’s Voting Algorithm Reference from::
	// https://www.geeksforgeeks.org/majority-element/
	public int majorityElement(int[] nums) {
		int leader = nums[0];
		int votes = 1;
		int len = nums.length;
		for (int i = 1; i < len; i++) {
			int current = nums[i];
			if (current == leader) {
				votes++;
			} else {
				votes--;
				if (votes == 0) {
					leader = current;
					votes = 1;
				}
			}
		}
		return leader;
	}

	// Alternate approach :: Extra Memory
	public int majorityElementExtraMem(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int halfLen = nums.length / 2;
		int majorityElement = 0;
		for (int n : nums) {
			Integer count = map.get(n);
			if (count == null) {
				count = 0;
			}
			if (count >= halfLen) {
				majorityElement = n;
				break;
			}
			map.put(n, count + 1);
		}
		return majorityElement;
	}
}
