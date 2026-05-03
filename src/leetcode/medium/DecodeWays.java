package leetcode.medium;

import java.util.Arrays;

public class DecodeWays {
    int[] waysToDecode;
    String s;

    public static void main(String args[]) {
        DecodeWays d = new DecodeWays();
        d.numDecodings("2101");
    }

    public int numDecodings(String string) {
        waysToDecode = new int[string.length()];
        Arrays.fill(waysToDecode, -1);
        s = string;
        return numDecodingsUtil(0);
    }

    public int numDecodingsUtil(int index) {
        if (index == s.length()) return 1;
        if (s.charAt(index) == '0') return 0;
        if (waysToDecode[index] != -1) return waysToDecode[index];
        int currNumber = s.charAt(index) - '0';
        if (currNumber == 0) return 0;
        int waysToDecodeWithCurrNextNumber = 0;

        if (index <= s.length() - 2) {
            int currAndNextNumber = currNumber * 10 + s.charAt(index + 1) - '0';
            if (currAndNextNumber <= 26) {
                waysToDecodeWithCurrNextNumber = numDecodingsUtil(index + 2);
            }
        }

        waysToDecode[index] = numDecodingsUtil(index + 1) + waysToDecodeWithCurrNextNumber;

        return waysToDecode[index];
    }
}
