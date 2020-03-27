package krishna.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Example 1:
 * 
 * Input: "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length
 * of 3.
 * 
 * [CATCH] : Consider empty string, no repetition string ("abc"),
 * "adbcabde","cdd","cabded" ,"bbbbb", "dvdf", "advdf", "a", "aa", "aab"
 * 
 * @author krishna_kumar
 *
 */
public class LongestSubStringWithoutRepeatingChars {
	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> tracker = new HashMap<>();
		int resultSize = 0;
		int len = s.length();
		int startIndex = 0;
		for (int currentIndex = 0; currentIndex < len; currentIndex++) {
			char currentChar = s.charAt(currentIndex);
			Integer previouslySeenIndex = tracker.get(currentChar);
			if (previouslySeenIndex != null && previouslySeenIndex >= startIndex) {
				int currentSize = currentIndex - startIndex;
				if (currentSize > resultSize) {
					resultSize = currentSize;
				}
				startIndex = previouslySeenIndex + 1;
			}
			tracker.put(currentChar, currentIndex);
		}
		if (len - startIndex > resultSize) {
			resultSize = len - startIndex;
		}
		return resultSize;
	}
}
