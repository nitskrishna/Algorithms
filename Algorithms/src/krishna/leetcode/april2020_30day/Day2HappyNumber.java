package krishna.leetcode.april2020_30day;

/**
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 *
 * 
 * @author krishna_kumar
 *
 */
public class Day2HappyNumber {
	private int sumOfDigitSquares(int n) {
		int x = n % 10;
		int result = x * x;
		while (n > 0) {
			n = n / 10;
			x = n % 10;
			result = result + (x * x);
		}
		return result;
	}

	public boolean isHappy(int n) {
		int slow = n;
		int fast = n;
		do {
			slow = sumOfDigitSquares(slow);
			if (slow == 1) {
				return true;
			}
			fast = sumOfDigitSquares(sumOfDigitSquares(fast));
		} while (slow != fast);
		return false;
	}
}
