package leetcode.medium;

public class RotateImage {

    public void rotate(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix.length];

        int n = matrix.length;
         for(int[] row : matrix){
             int r = 0;
             for(int column : row){
                 newMatrix[r++][n-1] = column;
             }
             n--;
         }

         for(int i = 0 ; i< matrix.length; i++) {
             for(int j = 0; j< matrix.length; j++) {
                 matrix[i][j] = newMatrix[i][j];
             }
         }
    }
}
