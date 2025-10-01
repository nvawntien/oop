
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
     * Một hàng được coi là "full" nếu tất cả các ô đều true.
     * Khi xóa, các hàng trên dịch xuống và thêm hàng trống ở trên cùng.
     */
    public void clearRows() {
        int width = grid.length;
        int height = grid[0].length;

        int toY = 0;

        for (int y = 0; y < height; y++) {
            if (!isFullRow(y)) {
                for (int x = 0; x < width; x++) {
                    grid[x][toY] = grid[x][y];
                }
                toY++;
            }
        }


        for (int y = toY; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[x][y] = false;
            }
        }
    }

    /**
     * Kiểm tra 1 dòng có full (toàn true) hay không
     */
    private boolean isFullRow(int y) {
        for (int x = 0; x < grid.length; x++) {
            if (!grid[x][y]) return false;
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
