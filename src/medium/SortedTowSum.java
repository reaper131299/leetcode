package medium;

public class SortedTowSum {

    public static void main(String[] args) {

        SortedTowSum s = new SortedTowSum();
        s.twoSum(new int[]{2,7,11,15}, 9);

    }

    public int[] twoSum(int[] numbers, int target) {
        int startIndex = 0;
        int endindex = numbers.length-1;

        while(startIndex<endindex){
            if(numbers[startIndex]+numbers[endindex]==target)
                return new int[]{startIndex+1, endindex+1};
            else if(numbers[startIndex]+numbers[endindex]<target){
                startIndex++;
            }else if(numbers[startIndex]+numbers[endindex]>target){
                endindex--;
            }
        }
        return new int[]{};
    }
}
