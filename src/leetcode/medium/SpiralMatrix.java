package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String args[]){
        SpiralMatrix s  = new SpiralMatrix();
        s.spiralOrder(new int[][]{
                {1,2,3,4,5}
        });
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length;

        int top = 0;
        int bottom = matrix.length;

        List<Integer> res = new ArrayList<>();

        while (left < right && top < bottom ) {

            //from left to right
            for(int i = left ; i<right;  i++) res.add(matrix[top][i]);
            top+=1;

            //from top to bottom
            for(int i = top; i< bottom; i++) res.add(matrix[i][right-1]);
            right-=1;

            if(left == right || top == bottom) break;

            //from right to left
            for(int i = right-1; i>=left; i--) res.add(matrix[bottom-1][i]);
            bottom-=1;

            //from bottom to top
            for(int i = bottom-1; i >= top; i--) res.add(matrix[i][left]);
            left+=1;
        }

        return res;
    }
}
