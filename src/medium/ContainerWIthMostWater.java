package medium;

public class ContainerWIthMostWater {

    public static void main (String[] args){
        ContainerWIthMostWater c = new ContainerWIthMostWater();
        c.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int currentMaxArea = 0;
        while(left<right){
            int min = Math.min(height[left], height[right]);
            currentMaxArea = Math.max((right-left)*(min), currentMaxArea);
            while(left<right && height[left]<=min) left++;
            while(left<right && height[right]<=min) right--;
            }
        return currentMaxArea;
    }
}
