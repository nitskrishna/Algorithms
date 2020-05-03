package krishna.leetcode.may2020_30day;

/**
 * Given an arbitrary ransom note string and another string containing letters
 * from all the magazines, write a function that will return true if the ransom
 * note can be constructed from the magazines ; otherwise, it will return false.
 * 
 * Each letter in the magazine string can only be used once in your ransom note.
 * 
 * Note: You may assume that both strings contain only lowercase letters.
 * 
 * canConstruct("a", "b") -> false 
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * 
 * @author krishna_k
 *
 */
public class Day3RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		if(magazine.length() < ransomNote.length()) {
			return false;
		}
		int[] magazineLetterCount = new int[26];
		for(char m : magazine.toCharArray()) {
			magazineLetterCount[m -'a']++;
		}
		for(char n : ransomNote.toCharArray()) {
			if(magazineLetterCount[n-'a'] == 0) {
				return false;
			}
			magazineLetterCount[n-'a']--;
		}
		return true;
	}
}
