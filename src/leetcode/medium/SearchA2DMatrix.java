package leetcode.medium;

public class SearchA2DMatrix {

    public static void main(String args[]){
        SearchA2DMatrix s = new SearchA2DMatrix();
        s.searchMatrix(new int[][]{new int[]{1}, new int[]{3}}, 0);

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int columns = matrix[0].length;
        return findNumber(matrix[findArr(matrix, 0, row-1, target, columns-1)], 0, columns-1, target);
    }

    public int findArr(int[][] matrix, int left, int right, int target, int columns) {
        int mid = left+((right-left)/2);
        int firstVal = matrix[mid][0];
        int lastVal = matrix[mid][columns];
        if(target >= firstVal && target <= lastVal) return mid;
        else if((left == right && right == mid) || left>right) return mid;
        else if(target<firstVal) return findArr(matrix, left, --mid, target, columns);
        else if(target>lastVal) return findArr(matrix, ++mid, right, target, columns);
        return 0;
    }

    public boolean findNumber(int[] arr, int left, int right, int target){
        int mid = left+((right-left)/2);
        if(target == arr[mid]) return true;
        else if(left == right || left>right) return false;
        else if(target<arr[mid]) return findNumber(arr, left, --mid, target);
        else if(target>arr[mid]) return findNumber(arr, ++mid, right, target);
        else return false;
    }
}
