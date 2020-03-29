//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
	private boolean[][] grid;
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		int width = grid[0].length;
		int colInReduced = 0;
		for (int i=0; i< width; i++) {
			if (!isFilled(i)) {
				copyCol(colInReduced, i);
				colInReduced++;
			}
		}
		fillWithFalses(colInReduced);
	}

	private void fillWithFalses(int to) {
		for (; to<grid[0].length; to++) {
			for (int i=0; i<grid.length; i++) {
				grid[i][to] = false;
			}
		}
	}

	private void copyCol(int to, int from) {
		for (int i=0; i<grid.length; i++) {
			grid[i][to] = grid[i][from];
		}
	}

	private boolean isFilled(int j) {
		int height = grid.length;
		for (int i = 0; i < height; i++) {
			if(!grid[i][j])
				return false;
		}
		return true;
	}

	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return grid;
	}
}
