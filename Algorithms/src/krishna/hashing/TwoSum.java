package krishna.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * @author krishna_kumar
 *
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer,Integer> constantLookUp = new HashMap<>();
		int len = nums.length;
		for(int secondIndex = 0; secondIndex < len; secondIndex++) {
			int secondNum = nums[secondIndex];
			int firstNum = target-secondNum;
			Integer probableFirstIndex = constantLookUp.get(firstNum);
			if(probableFirstIndex != null) {
				result[0] = probableFirstIndex;
				result[1] = secondIndex;
				return result;
			}
			constantLookUp.put(secondNum,secondIndex);
		}
		return result;
	}
}
