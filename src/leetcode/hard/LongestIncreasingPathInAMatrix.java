package leetcode.hard;

import java.util.Arrays;

public class LongestIncreasingPathInAMatrix {

    int[][] dp;

    public static void main(String args[]){
        LongestIncreasingPathInAMatrix l = new LongestIncreasingPathInAMatrix();
        l.longestIncreasingPath(new int[][]{
                {9,9,4},
                {6,6,8},
                {2,1,1}
        });
    }

    public int longestIncreasingPath(int[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        int max = Integer.MIN_VALUE;

        for(int[] n : dp){
            Arrays.fill(n, -1);
        }

        for(int i = 0; i< matrix.length; i++){
            for (int j = 0; j<matrix[0].length; j++){
                int tempMax  = longestIncreasingPathUtil(matrix, i, j);
                max = Math.max(tempMax, max);
            }
        }

        return max;
    }

    public int longestIncreasingPathUtil(int[][] matrix, int row, int col) {
        if(row<0 || col<0 || row>=matrix.length || col >= matrix[0].length){
            return 0;
        }

        if(dp[row][col] != -1 ) return dp[row][col];

        int left = 0;
        int right = 0;
        int up = 0;
        int down = 0;

        if(row-1>=0 && matrix[row-1][col] > matrix[row][col]){
            up = longestIncreasingPathUtil(matrix, row-1, col);
        }

        if(col-1>=0 && matrix[row][col-1] > matrix[row][col]){
            left = longestIncreasingPathUtil(matrix, row, col-1);
        }

        if(row+1<matrix.length && matrix[row+1][col] > matrix[row][col]){
            down = longestIncreasingPathUtil(matrix, row+1, col);
        }

        if(col+1< matrix[0].length && matrix[row][col+1] > matrix[row][col]){
            right = longestIncreasingPathUtil(matrix, row, col+1);
        }

        dp[row][col] = 1 + Math.max(Math.max(Math.max(left, right), up),down) ;

        return dp[row][col];
    }

}
