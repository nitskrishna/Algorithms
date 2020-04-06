package krishna.leetcode.april2020_30day;

/**
 * Given a non-empty array of integers, every element appears twice except for
 * one. Find that single one. Implement it without extra memory and in linear
 * time complexity 
 * 
 * @author krishna_kumar
 *
 */
public class Day1SingleNumber {
	public int singleNumber(int[] nums) {
		int result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			result = result ^ nums[i];
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 4, 1, 2 };
		System.out.println(new Day1SingleNumber().singleNumber(nums));
	}
}
