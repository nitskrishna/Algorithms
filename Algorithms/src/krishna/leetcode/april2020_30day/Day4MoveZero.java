package krishna.leetcode.april2020_30day;

/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Input: [0,1,0,3,12] Output: [1,3,12,0,0]
 * 
 * You must do this in-place without making a copy of the array. Minimize the
 * total number of operations.
 * 
 * @author acer
 *
 */
public class Day4MoveZero {
	public void moveZeroes(int[] nums) {
		int place = 0;
		int size = nums.length;
		for (int i = 0; i < size; i++) {
			int n = nums[i];
			if (n != 0) {
				nums[place] = n;
				place++;
			}
		}
		for (; place < size; place++) {
			nums[place] = 0;
		}
	}
}
