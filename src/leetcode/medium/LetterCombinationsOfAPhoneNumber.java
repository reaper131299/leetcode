package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    ArrayList<Character>[] numbers = new ArrayList[8];
    String digits;
    List<String> res = new ArrayList<>();

    public LetterCombinationsOfAPhoneNumber(){
        numbers[0] = new ArrayList<>(Arrays.asList('a','b','c'));
        numbers[1] = new ArrayList<>(Arrays.asList('d','e','f'));
        numbers[2] = new ArrayList<>(Arrays.asList('g','h','i'));
        numbers[3] = new ArrayList<>(Arrays.asList('j','k','l'));
        numbers[4] = new ArrayList<>(Arrays.asList('m','n','o'));
        numbers[5] = new ArrayList<>(Arrays.asList('p','q','r','s'));
        numbers[6] = new ArrayList<>(Arrays.asList('t','u','v'));
        numbers[7] = new ArrayList<>(Arrays.asList('w','x','y','z'));
    }

    public static void main(String args[]){
        LetterCombinationsOfAPhoneNumber l = new LetterCombinationsOfAPhoneNumber();
        l.letterCombinations("23");
    }

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        letterCombinationsUtil(0, new StringBuilder());
        return res;
    }

    public void letterCombinationsUtil(int pos, StringBuilder s) {
        if(pos == digits.length()){
            res.add(s.toString());
            return;
        }
        for(char ch : numbers[digits.charAt(pos)-'2']){
            letterCombinationsUtil(pos+1, s.append(ch));
            s.delete(s.length()-1, s.length());
        }
    }
}
