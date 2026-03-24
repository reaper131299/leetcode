package leetcode.medium;

import java.util.Arrays;

public class MaxAreaOfIsland {
    int rows;
    int columns;
    int[][] grid;

    public static void main(String args[]) {
        MaxAreaOfIsland n = new MaxAreaOfIsland();
        n.maxAreaOfIsland(new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 1, 1, 1}
        });
    }

    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        columns = grid[0].length;
        this.grid = grid;

        int res = 0;
        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(grid[i][j] == 1){
                    res = Math.max(res, calculateArea(i, j));
                }
            }
        }
        return res;
    }

    private int calculateArea(int i, int j) {
        if(i< 0 || j< 0 || i >= rows || j >= columns || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;

        return 1 + calculateArea(i+1, j) + calculateArea(i-1, j) + calculateArea(i, j+1) + calculateArea(i, j-1);
    }

}
