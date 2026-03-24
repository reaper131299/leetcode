package leetcode.medium;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    char[][] grid;

    public static void main(String args[]) {
        NumberOfIslands n = new NumberOfIslands();
        n.numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        });
    }

    public int numIslands(char[][] grid) {
        this.grid = grid;
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    findIsland(i, j);
                    res++;
                }
            }
        }

        return res;
    }

    public void findIsland(int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        findIsland(i + 1, j);
        findIsland(i, j + 1);
        findIsland(i - 1, j);
        findIsland(i, j - 1);
    }
}






























