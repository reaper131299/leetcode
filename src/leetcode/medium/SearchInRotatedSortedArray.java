package leetcode.medium;

public class SearchInRotatedSortedArray {

    public static void main (String args[]) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        s.search(new int[]{1,2}, 3);
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int index = -1;
        while(left<=right){
            int mid = left + ((right-left)/2);
            if(nums[mid] == target) {index = mid; break;}
            else if(nums[left]<=nums[mid]) {
                if (target >= nums[left] && target <= nums[mid]){
                    right = mid - 1;
                } else {
                    left = mid+1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid+1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return index;
    }
}
