package krishna.hashing;

/**
 * Given an arbitrary ransom note string and another string containing letters
 * from all the magazines, write a function that will return true if the ransom
 * note can be constructed from the magazines ; otherwise, it will return false.
 * 
 * Each letter in the magazine string can only be used once in your ransom note.
 * 
 * Note: You may assume that both strings contain only lower case letters.
 * 
 * canConstruct("z", "b") -> false 
 * canConstruct("zz", "zb") -> false
 * canConstruct("zz", "zzb") -> true
 * 
 * @author krishna_kumar
 *
 */
public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		if (magazine.length() < ransomNote.length()) {
			return false;
		}
		int[] magazineLetterCount = new int[26];
		for (char m : magazine.toCharArray()) {
			magazineLetterCount[m - 'a']++;
		}
		for (char n : ransomNote.toCharArray()) {
			if (magazineLetterCount[n - 'a'] == 0) {
				return false;
			}
			magazineLetterCount[n - 'a']--;
		}
		return true;
	}
}
