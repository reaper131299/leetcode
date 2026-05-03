package leetcode.medium;

public class ReverseInteger {

    public int reverse(int x) {
        int reversedInt = 0;
        while (x>0) {
            int newInt = reversedInt*10 + x%10;
            if((newInt - x%10)/10 != reversedInt) return 0;
            reversedInt = newInt;
        }

        return reversedInt;
    }
}
