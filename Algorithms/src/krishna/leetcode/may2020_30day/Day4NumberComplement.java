package krishna.leetcode.may2020_30day;

/**
 * Given a positive integer, output its complement number. The complement
 * strategy is to flip the bits of its binary representation.
 * 
 * Example 1:
 * 
 * Input: 5
 * 
 * Output: 2
 * 
 * Explanation: The binary representation of 5 is 101 (no leading zero bits),
 * and its complement is 010. So you need to output 2.
 * 
 * 
 * Example 2:
 * 
 * Input: 1
 * 
 * Output: 0
 * 
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and
 * its complement is 0. So you need to output 0.
 * 
 * Note:
 * 
 * The given integer is guaranteed to fit within the range of a 32-bit signed
 * integer. You could assume no leading zero bit in the integer’s binary
 * representation. This question is the same as 1009:
 * https://leetcode.com/problems/complement-of-base-10-integer/
 * 
 * @author krishna_k
 *
 */
public class Day4NumberComplement {
	public int findComplement(int num) {
		int i = 0;
		int result = 0;
		int numOfSetBits = getNumOfBits(num);
		while(numOfSetBits > 0) {
			int checker = (1<<i);
			boolean isIthBitSet = !((num & checker) == 0); 
			if(!isIthBitSet) {
				result = result | checker;
			}
			i++;
			numOfSetBits--;
		}
		return result;
	}
	private int getNumOfBits(int num) {
		int numOfBits = 0;
		while(num > 0) {
			numOfBits++;
			num = num >> 1;
		}
		return numOfBits;
	}
	
	
}
