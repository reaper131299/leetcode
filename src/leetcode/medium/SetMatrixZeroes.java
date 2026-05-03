package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetMatrixZeroes {

    boolean[] rows;
    boolean[] columns;

    public void setZeroes(int[][] matrix) {
        List<Integer> arr = new ArrayList<>();
        rows = new boolean[matrix.length];
        columns = new boolean[matrix[0].length];

        for(int row= 0; row< matrix.length; row++) {
            for(int column = 0; column<matrix[0].length; column++) {
                if(matrix[row][column] == 0) {
                    arr.add(row);
                    arr.add(column);
                }
            }
        }

        for(int i = 0; i<arr.size(); i+=2) {
            setZeros(matrix, arr.get(i), arr.get(i+1));
        }
     }

    private void setZeros(int[][] matrix, int row, int column) {
        if(!rows[row]) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
            rows[row] = true;
        }

        if(!columns[column]) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][column] = 0;
            }
            columns[column] = false;
        }
    }
}
