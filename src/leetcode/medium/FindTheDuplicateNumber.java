package leetcode.medium;

public class FindTheDuplicateNumber {

    public static void main(String args[]) {
        FindTheDuplicateNumber f = new FindTheDuplicateNumber();
        f.findDuplicate(new int[]{1,3,4,2,2});
    }

    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];

        } while (slow != fast);

        int slow2 = 0;
        while(slow!=slow2){
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
    }
}
