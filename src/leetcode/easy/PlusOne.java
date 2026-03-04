package leetcode.easy;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        PlusOne p = new PlusOne();
        System.out.println(Arrays.toString(p.plusOne(new int[]{9})));

    }

    public int[] plusOne(int[] digits) {
        int carry;
        int num = digits[digits.length - 1];
        int start = digits.length - 2;
        if (num > 8) {
            carry = 1;
            digits[digits.length - 1] =0;
        } else {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            return digits;
        }

        while (carry != 0 && start >=0) {
            if (digits[start] > 8) {
                digits[start] =0;
            } else {
                carry = 0;
                digits[start] = digits[start] + 1;
            }
            start--;
        }
        if(carry == 1) {
            int[] newarr = new int[digits.length + 1];
            newarr[0] = 1;
            System.arraycopy(digits, 0, newarr, 1, newarr.length - 1);
            return newarr;
        }
        return digits;
    }
}
