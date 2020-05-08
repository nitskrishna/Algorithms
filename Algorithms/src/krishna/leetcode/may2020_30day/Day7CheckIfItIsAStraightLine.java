package krishna.leetcode.may2020_30day;

/**
 * URL :
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3323/
 * 
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y]
 * represents the coordinate of a point. Check if these points make a straight
 * line in the XY plane.
 * 
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]] Output: true
 * 
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]] Output: false
 * 
 * Constraints:
 * 
 * 2 <= coordinates.length <= 1000
 * 
 * coordinates[i].length == 2
 * 
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * 
 * coordinates contains no duplicate point.
 * 
 * 
 * @author krishna_k
 *
 */
public class Day7CheckIfItIsAStraightLine {
	public boolean checkStraightLine(int[][] coordinates) {
		// y1 = m*x1 + c;
		// y2 = m*x2 + c;
		// y1-y2 = m*(x1-x2);
		// m = (y1-y2)/(x1-x2);
		if (coordinates == null || coordinates.length == 0) {
			return false;
		}
		int n = coordinates.length;
		if (n == 1 || n == 2) {
			return true;
		}
		int x0 = coordinates[0][0];
		int y0 = coordinates[0][1];
		int x1 = coordinates[1][0];
		int y1 = coordinates[1][1];
		double m1 = ((double) (y0 - y1)) / (x0 - x1); // this is important, specially the RHS side casting
		for (int i = 2; i < n; i++) {
			int xi = coordinates[i][0];
			int yi = coordinates[i][1];
			double mi = (((double) (y0 - yi)) / (x0 - xi)); // this is important, specially the RHS side casting
			System.out.println(m1 + " " + mi);
			if (m1 != mi) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
//		[[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
		int[][] coordinates = { { 1, 2 }, { 2, 2 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 7, 7 } };
		Day7CheckIfItIsAStraightLine o = new Day7CheckIfItIsAStraightLine();
		boolean b = o.checkStraightLine(coordinates);
		System.out.println(b);
	}
}
