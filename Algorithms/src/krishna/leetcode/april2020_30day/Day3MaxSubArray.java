package krishna.leetcode.april2020_30day;

/**
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6 Explanation: [4,-1,2,1] has the
 * largest sum = 6.
 * 
 * @author krishna_kumar
 *
 */
public class Day3MaxSubArray {
	public int maxSubArray(int[] nums) {
		int maxSubArray = Integer.MIN_VALUE;
		int temp = 0;
		int max = Integer.MIN_VALUE;
		for (int n : nums) {
			temp += n;
			if (temp < 0) {
				temp = 0;
			}
			if (temp > maxSubArray) {
				maxSubArray = temp;
			}
			if (n > max) {
				max = n;
			}
		}
		if (max < 0) {
			return max;
		}
		return maxSubArray;
	}

	public static void main(String[] args) {
		int[] nums = { -2, -9, 2, -1, -10, 20 };
		int result = new Day3MaxSubArray().maxSubArray(nums);
		System.out.println(result);
	}
}