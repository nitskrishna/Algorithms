package krishna.extras;

import java.util.Arrays;

/**
 * 
 * @author krishna_kumar
 * 
 *         Input : array of Integers
 * 
 *         Output : array of length 2, representing the largest range of numbers
 *         contained in the input array.The first number is the output array
 *         should be the first number in the range while second number should
 *         be the last number in the range.There would be only one largest range
 *         in the input array
 * 
 *         input = {19, -1, 18, 17, 2, 10, 3, 12, 5, 16, 4, 11, 8, 7, 6, 15, 12,
 *         12, 2, 1, 6, 13, 14} output = {10,19}
 *
 */
public class LargestRange {
	public static int[] largestRange(int[] array) {
		Arrays.sort(array);
		int[] largestRange = new int[2];
		int low = array[0];
		int high = array[0];
		int size = 1;
		int N = array.length;
		int tLow = array[0];
		int tSize = 1;
		for (int i = 1; i < N; i++) {
			if (array[i - 1] == array[i]) {
				if (i == N - 1 && (tSize > size)) {
					low = tLow;
					high = array[i];
					size = tSize;
				}
			} else if (array[i - 1] + 1 == array[i]) {
				tSize++;
				if (i == N - 1 && (tSize > size)) {
					low = tLow;
					high = array[i];
					size = tSize;
				}
			} else {
				if (tSize > size) {
					low = tLow;
					high = array[i - 1];
					size = tSize;
				}
				tLow = array[i];
				tSize = 1;
			}
		}
		largestRange[0] = low;
		largestRange[1] = high;
		return largestRange;
	}

}
