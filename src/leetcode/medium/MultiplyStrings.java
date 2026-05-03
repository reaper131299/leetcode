package leetcode.medium;

import java.util.Arrays;

public class MultiplyStrings {

    public static void main(String args[]) {
        MultiplyStrings m = new MultiplyStrings();
        m.multiply("0", "0");
    }

    public String multiply(String num1, String num2) {
        char[] reversedNum1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] reversedNum2 = new StringBuilder(num2).reverse().toString().toCharArray();

        int[] res = new int[num1.length()+num2.length()];

        for(int i = 0; i<reversedNum1.length; i++){
            for(int j = 0; j<reversedNum2.length; j++){
                int sum = res[i+j] + (reversedNum1[i]-'0')*(reversedNum2[j]-'0');
                res[i+j] = sum%10;
                res[i+j+1] = res[i+j+1] + sum/10;
            }
        }

        int i = res.length-1;
        while (i>=1 && res[i] == 0) i--;

        char[] chars = new char[i+1];
        int x = 0;
        for(int idx = i; idx >= 0; idx--){
            chars[x] = (char)(res[idx] + '0');
            x++;
        }

        return new String(chars);
    }
}
