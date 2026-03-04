package leetcode.hard;

public class TrappingWater {

    public static void main(String[] args){
        TrappingWater t = new TrappingWater();
//        t.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        t.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
//        t.trap(new int[]{2,0,3,0,2});
//        t.countTrappedWater(new int []{3,1,1,0,1,1,3}, 0, 6);
    }

    //brut force method
//    public int trap(int[] height) {
//        int firstNonZeroHeightIdx=0;
//        int trappedWaterQt = 0;
//        for(int i = 0; i< height.length-1; i++){
//            if(height[i]>0){
//                firstNonZeroHeightIdx = i;
//                break;
//            }
//        }
//        for(int i = firstNonZeroHeightIdx; i<height.length-1; i++){
//            int nextBound = findNextBound(height, i);
//            trappedWaterQt = trappedWaterQt + countTrappedWater(height, i, nextBound);
//            i = nextBound;
//            while(i<height.length-1 && height[i]==height[i+1]){
//                i++;
//            }
//            i--;
//        }
//
//
//        return trappedWaterQt;
//    }
//
//    private int countTrappedWater(int[] height, int leftIndex, int rightIndex) {
//        int leftHeight = height[leftIndex];
//        int rightHeight = height[rightIndex];
//        int maxWaterHeight = Math.min(leftHeight,rightHeight);
//        int trapperWater = 0;
//        for(int i = leftIndex+1;i<=rightIndex-1;i++){
//            trapperWater  = trapperWater + (maxWaterHeight-height[i]);
//        }
//
//        return trapperWater;
//    }
//
//    private int findNextBound(int[] height, int i) {
//        int leftHeight = height[i];
//        int rightIdx = i+1;
//        int nextMax = height[i+1];
//        int indexOfRightMax = i+1;
//        while(rightIdx<height.length){
//            if(height[rightIdx]>=leftHeight){
//                return rightIdx;
//            }else {
//                if(Math.max(height[rightIdx], nextMax) > nextMax ){
//                    nextMax = Math.max(height[rightIdx], nextMax);
//                    indexOfRightMax = rightIdx;
//                }
//                rightIdx++;
//            }
//        }
//        return indexOfRightMax;
//    }

    public int trap(int[] height) {
        int n = height.length;
        int maxLeft = 0;
        int maxRight = 0;
        int left = 0;
        int right = n-1;
        int waterTrapped = 0;
        while(left<right){
            if(height[left]<=height[right]){
                if(maxLeft<height[left]){
                    maxLeft = height[left];
                } else {
                    waterTrapped = waterTrapped + (maxLeft-height[left]);
                }
                left++;
            } else if (height[right]<height[left]){
                if(maxRight<height[right]){
                    maxRight = height[right];
                } else {
                    waterTrapped = waterTrapped + (maxRight-height[right]);
                }
                right--;
            }
        }
        return waterTrapped;
    }
}
