package leetcode.easy;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        PlusOne p = new PlusOne();
        System.out.println(Arrays.toString(p.plusOne(new int[]{9})));

    }

    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length-1; i>=0; i--) {
            int sum = digits[i]+carry;
            digits[i] = (sum)%10;
            carry = sum/10;
        }

        if(carry == 1) {
            int[] newDigits = new int[digits.length+1];
            newDigits[0] = carry;
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            return newDigits;
        }

        return digits;
    }
}
