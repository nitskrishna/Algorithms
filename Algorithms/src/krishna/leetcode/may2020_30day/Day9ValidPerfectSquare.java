package krishna.leetcode.may2020_30day;

/**
 * Given a positive integer num, write a function which returns True if num is a
 * perfect square else False.
 * 
 * Note: Do not use any built-in library function such as sqrt.
 * 
 * Example 1:
 * 
 * Input: 16 Output: true Example 2:
 * 
 * Input: 14 Output: false
 * 
 * 
 * NOTE : Solution's Runtime beats 100% of Java Solutions till : 9-May-2020 at
 * 1:52 PM (IST)
 * 
 * @author krishna_k
 *
 */
public class Day9ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
		if (num == 1) {
			return true;
		}
		if (num < 4) {
			return false;
		}

		boolean isEven = num % 2 == 0;
		long start = isEven ? 2 : 3;
		long end = num / 2;
		while (start <= end) {
			long startSq = (start * start);
			if (startSq > num || startSq <= 0) {
				return false;
			}

			long m = start + (end - start) / 2;
			long square = m * m;
			if (square <= 0) {
				// overflow
				square = Long.MAX_VALUE;
			}
			if (square == num) {
				return true;
			} else if (square < num) {
				start = m + 1;
			} else {
				end = m - 1;
			}
		}
		return false; // if the while loop gets over and result not found return true
	}

	public static void main(String[] args) {
		Day9ValidPerfectSquare o = new Day9ValidPerfectSquare();
		int[] checkFor = { 14, 4, 3, 2147483647, 808201 };
		for (int check : checkFor) {
			boolean isValidSquare = o.isPerfectSquare(check);
			System.out.println("is " + check + " a perfect square ? " + isValidSquare);
		}
	}

}
