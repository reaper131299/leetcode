package leetcode.medium;

public class FindMinimumnRotatedSortedArray  {
    public static void main (String args[]) {
        FindMinimumnRotatedSortedArray f = new FindMinimumnRotatedSortedArray();
        f.findMin(new int[]{3,1,2});
    }

    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;

        while(left<=right){
            int mid = left+((right-left)/2);
            if(left == right )return nums[left];
            else if(nums[left]<nums[right]) return nums[left];
            else if(nums[left]<=nums[mid]) {
                left = mid+1;
            } else if(nums[mid]<nums[right]){
                right = mid;
            }
        }

        return 0;
    }
}
