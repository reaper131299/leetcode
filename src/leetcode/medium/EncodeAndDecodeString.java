package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeString {
    static Map<Character, String> charToInt;
    static  char[] intToChar;

    static {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ \t\n\r";
        charToInt = new HashMap<>();
        intToChar = new char[chars.length()];

        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            String code = String.format("%02d", i);
            charToInt.put(c, code);
            intToChar[i] = c;
        }
    }

    public static void main(String[] args) {
        EncodeAndDecodeString e = new EncodeAndDecodeString();
        String[] ar1 = e.decode(e.encode(new String[]{"Hello","World"}));
        String[] ar2 = e.decode(e.encode(new String[]{"abc","!@"}));
    }

    public String encode(String s[]) {
        StringBuilder sb= new StringBuilder();
        for (String str : s){
            sb.append(convertTonums(str)).append("||");
        }
        return sb.toString();
    }

    private String convertTonums(String str) {
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()){
            sb.append(charToInt.get(c));
        }
        return sb.toString();
    }

    public String[] decode(String s) {
        String[] arr = s.split("\\|\\|");
        for (int i = 0; i<arr.length;i++){
            arr[i] = splitEveryTwoChars(arr[i]);
        }
        return arr;
    }

    public static String splitEveryTwoChars(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, idx = 0; i < len; i += 2, idx++) {
            sb.append(intToChar[Integer.parseInt(s.substring(i, Math.min(i + 2, len)))]);
        }
        return sb.toString();
    }
}
