package leetcode.easy;

public class HappyNumber  {
    public static void main(String[] args) {
        HappyNumber h = new HappyNumber();
        h.isHappy(19);
    }

    public boolean isHappy(int n) {
        int slow = getSum(n);
        int fast = getSum(getSum(n));

        while(slow != 1 && fast !=1 && slow != fast) {
            slow = getSum(slow);
            fast = getSum(getSum(fast));
        }

        return slow == 1 || fast == 1;
    }

    private int getSum(int n) {
        int sum = 0;

        while (n != 0) {
            int r = n%10;
            sum = sum + r*r;
            n = n/10;
        }

        return sum;
    }
}
