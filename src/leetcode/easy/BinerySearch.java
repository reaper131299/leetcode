package leetcode.easy;

public class BinerySearch {

    public static void main(String[] args) {
        search(new int[]{-1,0,3,5,9,12}, 2);
    }

    public static int search(int[] nums, int target) {
        int leftIndex = 0;
        int middleIndex = nums.length/2;
        int rightIndex = nums.length-1;

        while(nums[middleIndex]!=target) {
            if(middleIndex == leftIndex && middleIndex == rightIndex)
                return -1;
            if(target<nums[middleIndex])
                rightIndex = middleIndex-1;
            else if(target>nums[middleIndex])
                leftIndex = middleIndex+1;

            middleIndex = leftIndex + ((rightIndex-leftIndex)/2);
        }
        return middleIndex;
    }
}
