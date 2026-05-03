package leetcode.medium;

public class UniquePaths {

    public static void main(String args[]){
        UniquePaths u = new UniquePaths();
        u.uniquePaths(3,7);
    }

    public int uniquePaths(int m, int n) {
        if (m==1 || n ==1) return 1;

        int[][] grid = new int[m][n];

        for(int i = 0; i<m; i++){
            grid[i][0] = 1;
        }

        for(int i = 0; i<n; i++){
            grid[0][i] = 1;
        }

        for(int row = 1; row<m; row++){
            for(int col = 1; col<n; col++){
                grid[row][col] = grid[row-1][col] + grid[row][col-1];
            }
        }

        return grid[m-1][n-1];
    }
}
