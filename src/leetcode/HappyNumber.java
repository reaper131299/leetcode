package leetcode;

public class HappyNumber  {
    public static void main(String[] args) {
        HappyNumber h = new HappyNumber();
        h.isHappy(19);
    }

    public boolean isHappy(int n) {
        int slow;
        int fast;
        slow = getSum(n);
        fast = getSum(getSum(n));
        while(slow != 1 && fast !=1 && slow != fast){
            slow = getSum(slow);
            fast = getSum(getSum(fast));
        }
        return slow == 1 || fast == 1;

    }

    int getSum(int n){
        int sum = 0;
        while(n!=0){
            sum = (int)(sum + Math.pow((n%10),2));
            n = n/10;
        }
        return sum;
    }
}
