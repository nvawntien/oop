// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

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
        int rows = grid.length;
        if (rows == 0) return 0;
        int cols = grid[0].length;

        int minRow = Integer.MAX_VALUE, maxRow = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE, maxCol = Integer.MIN_VALUE;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == ch) {
                    minRow = Math.min(minRow, r);
                    maxRow = Math.max(maxRow, r);
                    minCol = Math.min(minCol, c);
                    maxCol = Math.max(maxCol, c);
                }
            }
        }

        if (minRow == Integer.MAX_VALUE) return 0;

        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {

        int rows = grid.length;
        if (rows == 0) return 0;
        int cols = grid[0].length;

        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                char ch = grid[r][c];

                int up = countDir(r, c, -1, 0, ch);
                int down = countDir(r, c, 1, 0, ch);
                int left = countDir(r, c, 0, -1, ch);
                int right = countDir(r, c, 0, 1, ch);

                int armLen = Math.min(Math.min(up, down), Math.min(left, right));

                if (armLen >= 2) {
                    count++;
                }
            }
        }

        return count;
	}

    private int countDir(int r, int c, int dr, int dc, char ch) {
        int len = 0;
        int rows = grid.length, cols = grid[0].length;

        r += dr; c += dc;
        while (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == ch) {
            len++;
            r += dr; c += dc;
        }
        return len;
    }
	
}
