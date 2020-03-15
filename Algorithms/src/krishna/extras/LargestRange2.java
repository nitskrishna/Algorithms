package krishna.extras;

import java.util.HashMap;

/**
 * 
 * @author krishna_kumar
 * 		
 * 		[Solution: Hashing ]
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
public class LargestRange2 {
	public static int[] largestRange(int[] array) {
		int[] largestRange = new int[2];
		HashMap<Integer,Boolean> visited = new HashMap<>();
		for(int x : array) {
			visited.put(x, false);
		}
		int low = 0, high = 0, size = 0;
		for(int x: array) {
			if(!visited.get(x)) {
				visited.put(x,true);
				int left = x-1;
				while(visited.containsKey(left)) {
					visited.put(left, true);
					left = left -1;
				}
				left = left + 1;
				int right = x+1;
				while(visited.containsKey(right)) {
					visited.put(right, true);
					right = right + 1;
				}
				right = right - 1;
				int tSize = right - left + 1;
				if(tSize > size) {
					low = left;
					high = right;
					size = tSize;
				}
			}
		}
		largestRange[0] = low;
		largestRange[1] = high;
		return largestRange;
	}
}
