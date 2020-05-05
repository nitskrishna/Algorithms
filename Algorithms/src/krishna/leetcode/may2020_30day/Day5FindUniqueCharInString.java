package krishna.leetcode.may2020_30day;

/**
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode" return 0.
 * 
 * s = "loveleetcode", return 2.
 * 
 * 
 * Note: You may assume the string contain only lowercase letters.
 * 
 * @author krishna_k
 *
 */
public class Day5FindUniqueCharInString {
	public int firstUniqChar(String s) {
		int[] marker = new int[26];
		char[] arr = s.toCharArray();
		for (char c : arr) {
			marker[c - 'a']++;
		}
		int i = 0;
		for (char c : arr) {
			if (marker[c - 'a'] == 1) {
				return i;
			}
			i++;
		}
		return -1;
	}
}
