package leetcode.medium;

public class MaximumProductSubarray {

    public static void main(String args[]) {
        MaximumProductSubarray m = new MaximumProductSubarray();
        m.maxProduct(new int[]{-2, 3, -4});
    }

//    public int maxProduct(int[] nums) {
//        int max = Integer.MIN_VALUE;
//        int[] numsCopy = new int[nums.length];
//        for(int i = 0; i<nums.length; i++){
//            numsCopy[i] = nums[i];
//            if(nums[i]>max){
//                max = nums[i];
//            }
//        }
//        for(int i = 1; i<nums.length; i++){
//            int[] prodArr = new int[numsCopy.length-1];
//            int prodArrIdx = -1;
//            for(int j = i; j<nums.length; j++){
//                prodArrIdx++;
//                prodArr[prodArrIdx] = nums[j] * numsCopy[prodArrIdx];
//                if(prodArr[prodArrIdx] > max){
//                    max = prodArr[prodArrIdx];
//                }
//            }
//            numsCopy = prodArr;
//        }
//        return max;
//    }

//    public int maxProduct(int[] nums) {
//        int max = Integer.MIN_VALUE;
//        int currMax = 1;
//        int currMin = 1;
//        for (int num : nums) {
//            if (num == 0) {
//                currMax = 1;
//                currMin = 1;
//                max = findMax(max, num);
//                continue;
//            }
//
//            int tempCurrMax = currMax;
//            currMax = findMax(num * currMax, num * currMin, num);
//            currMin = findMin(num * tempCurrMax, num * currMin, num);
//
//            max = findMax(currMax, currMin, max);
//        }
//
//        return max;
//    }
//
//    private int findMax(int... nums) {
//        int max = Integer.MIN_VALUE;
//        for(int n : nums){
//            if (n > max) max = n;
//        }
//        return max;
//    }
//
//    private int findMin(int... nums) {
//        int min = Integer.MAX_VALUE;
//        for(int n : nums){
//            if (n < min) min = n;
//        }
//        return min;
//    }

    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;

        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            prefix *= nums[i];
            res = Math.max(prefix, res);
            if (prefix == 0) prefix = 1;
        }


        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            suffix *= nums[i];
            res = Math.max(suffix, res);
            if (suffix == 0) suffix = 1;
        }

        return res;
    }
}
