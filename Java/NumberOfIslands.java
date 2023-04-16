import java.util.Arrays;

public class NumberOfIslands {
    // Recursive DFS to explore island and make visited '1's to '0's
    public void exploreIsland(char[][] grid, int i, int j, int rowSize, int colSize) {
        if (i >= 0 && i <= rowSize && j >= 0 && j <= colSize) {
            if (grid[i][j] == '1') {
                grid[i][j] = '0';
                exploreIsland(grid, i, j - 1, rowSize, colSize);
                exploreIsland(grid, i - 1, j, rowSize, colSize);
                exploreIsland(grid, i, j + 1, rowSize, colSize);
                exploreIsland(grid, i + 1, j, rowSize, colSize);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int numIslands = 0;
        int rowSize = grid.length;
        int colSize = grid[0].length;

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (grid[i][j] == '1') {
                    exploreIsland(grid, i, j, rowSize - 1, colSize - 1);
                    numIslands++;
                }
            }
        }

        return numIslands;
    }

    public void func() {
        char[][] grid = new char[][] {
                {'0', '1'},
                {'1', '0'}
        };
        System.out.println(numIslands(grid));
    }

    public static void main (String[] args) {
        NumberOfIslands obj = new NumberOfIslands();
        obj.func();
    }
}
