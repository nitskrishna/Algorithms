package krishna.dfs;

import java.util.*;

/**
 * 
 * @author krishna_kumar
 * 
 *         input : 2-D array with potentially unequal height and width
 *         containing only 0s and 1s. Each 0 represents land and each 1
 *         represents part of a river. A river consists of any number of 1s that
 *         are either horizontally or vertically adjacent ( but not diagonally
 *         adjacent). The number of 1s forming a river determine its size.
 * 
 *         Output : array of the sized of all the rivers represented in the
 *         input 2-D array. (Sizes need not be in any particular order)
 */
public class RiverSizes {
	public static List<Integer> riverSizes(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		if (matrix == null || matrix.length == 0) {
			return list;
		}
		int N = matrix.length;
		int M = matrix[0].length;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] == 1) {
					list.add(riverSize(i, j, 0, matrix, N, M));
				}
			}
		}
		return list;
	}

	private static int riverSize(int i, int j, int size, int[][] matrix, int N, int M) {
		if (isSafe(i, j, N, M) && matrix[i][j] == 1) {
			size++;
			matrix[i][j] = 0; // reset it so as to avoid revisit and re include in size calculation
		}
		int[] incrementI = { -1, 1, 0, 0 };
		int[] incrementJ = { 0, 0, -1, 1 };
		for (int x = 0; x < 4; x++) {
			int cI = i + incrementI[x];
			int cJ = j + incrementJ[x];
			if (isSafe(cI, cJ, N, M) && matrix[cI][cJ] == 1) {
				size = riverSize(cI, cJ, size, matrix, N, M);
			}
		}
		return size;
	}

	private static boolean isSafe(int i, int j, int N, int M) {
		return i < N && i >= 0 && j < M && j >= 0;
	}
}