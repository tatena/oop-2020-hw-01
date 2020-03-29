// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

import java.util.HashSet;

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		if (grid.length < 1)
			return 0;
		int maxX = -1;
		int minX = grid.length;
		int minY = grid[0].length;
		int maxY = -1;
		for (int i = 0; i< grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == ch) {
					maxX = Math.max(maxX, i);
					minX = Math.min(minX, i);
					maxY = Math.max(maxY, j);
					minY = Math.min(minY, j);
				}
			}
		}
		int x = maxX - minX + 1;
		int y = maxY - minY + 1;
		return maxX!=-1 ? x*y : 0;
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		if (grid.length < 1)
			return 0;
		int height  = grid.length;
		int width = grid[0].length;
		int res = 0;
		for (int i=0; i<height; i++) {
			for (int j = 0; j<width; j++) {
				res += isPlusCenter (i, j);
			}
		}
		return res;
	}

	private int isPlusCenter(int n, int m) {
		HashSet<Integer> sizes = new HashSet<Integer>();
		for (int i=-1; i<2; i++) {
			for (int j =-1; j <2; j++) {
				if (Math.abs(i) != Math.abs(j)) {
					sizes.add(getLegSize(n, m, i, j));
					if (sizes.size() > 1)
						return 0;
				}
			}
		}
		return sizes.contains(1) ? 0 : 1;
	}

	private int getLegSize(int i, int j, int iDir, int jDir) {
		char ch = grid[i][j];
		int res = 0;
		while (inBounds(i, j) && grid[i][j]==ch) {
				res++;
				i+=iDir;
				j+=jDir;
		}
		return res;
	}

	private boolean inBounds(int i, int j) {
		return (i > -1 && i<grid.length && j >-1 && j < grid[0].length);
	}
}
