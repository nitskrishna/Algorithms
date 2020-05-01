package krishna.leetcode.may2020_30day;

/**
 * You are a product manager and currently leading a team to develop a new
 * product. Unfortunately, the latest version of your product fails the quality
 * check. Since each version is developed based on the previous version, all the
 * versions after a bad version are also bad.
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first
 * bad one, which causes all the following ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which will return whether
 * version is bad. Implement a function to find the first bad version. You
 * should minimize the number of calls to the API.
 * 
 * @author krishna_k
 *
 */
public class Day1VersionControl {
	/*
	 * The isBadVersion API is defined in the parent class Day1VersionControl.
	 * boolean isBadVersion(int version);
	 */
	

	public int firstBadVersion(int n) {
		if (n == 1) {
			return 1;
		}
		if (isBadVersion(1)) {
			return 1;
		}
		int l = 0;
		int r = n;
		int firstBadVersion = n; // init it carefully else cases like n = 2 & firstBadVersion = 2 will fail
		while (l < r) {
			int m = l + ((r - l) / 2);
			if (isBadVersion(m)) {
				firstBadVersion = m;
				r = m;
			} else {
				l = m + 1;
			}
		}
		return firstBadVersion;
	}

}
