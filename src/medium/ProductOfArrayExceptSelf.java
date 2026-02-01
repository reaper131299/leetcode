package medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        ProductOfArrayExceptSelf p = new ProductOfArrayExceptSelf();
        p.productExceptSelf(new int[]{1,2,3,4});
    }

//    public int[] productExceptSelf(int[] nums) {
//        int product = 1;
//        int numberofZeros = 0;
//        for(int i=0; i<nums.length; i++){
//            if(nums[i]!=0){
//                product = product*nums[i];
//            } else {
//                numberofZeros++;
//            }
//
//        }
//        int[] result = new int[nums.length];
//        if(numberofZeros>1){
//            return result;
//        }
//        for(int i = 0; i<nums.length; i++) {
//            if (nums[i] == 0)
//                result[i] = product;
//            else if(nums[i] != 0 && numberofZeros==1)
//                result[i] = 0;
//            else
//                result[i] = product/nums[i];
//        }
//        return result;
//    }
    public int[] productExceptSelf(int[] nums) {
        int[] leftProd = new int[nums.length];
        int[] rightProd = new int[nums.length];
        leftProd[0] = 1;
        rightProd[nums.length-1] = 1;
        int prod = 1;
        for(int i = 1; i<nums.length;i++){
            prod= prod*nums[i-1];
            leftProd[i] = prod;
        }
        prod = 1;
        for(int i = nums.length-2; i>=0;i--){
            prod = prod*nums[i+1];
            rightProd[i] = prod;
        }
        for(int i = 0; i<nums.length;i++){
            leftProd[i] = leftProd[i]*rightProd[i];
        }
        return leftProd;
    }
}
