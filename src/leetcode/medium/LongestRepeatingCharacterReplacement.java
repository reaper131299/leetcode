package leetcode.medium;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement l = new LongestRepeatingCharacterReplacement();
        l.characterReplacement("ABCDEF",1);
    }

//    public int characterReplacement(String s, int k) {
//        int res = 0;
//        int leftIdx = 0;
//        int rightIdx = 0;
//        Map<Character, Integer> freqMap = new HashMap<>();
//        char[] chars = s.toCharArray();
//        while (rightIdx < chars.length) {
//            freqMap.putIfAbsent(chars[rightIdx], 0);
//            freqMap.put(chars[rightIdx], freqMap.get(chars[rightIdx]) + 1);
//            if (isWindowValid(freqMap, leftIdx, rightIdx, chars, k)) {
//                res = Math.max(res, rightIdx - leftIdx + 1);
//                rightIdx++;
//            } else {
//                freqMap.put(chars[leftIdx], freqMap.get(chars[leftIdx]) - 1);
//                leftIdx++;
//                rightIdx++;
//            }
//        }
//        return res;
//    }
//
//    private boolean isWindowValid(Map<Character, Integer> freqMap, int leftIdx, int rightIdx, char[] chars, int k) {
//        int mostFrequency = 0;
//        for (Map.Entry<Character, Integer> e : freqMap.entrySet()) {
//            if (e.getValue() > mostFrequency)
//                mostFrequency = e.getValue();
//        }
//        int length = rightIdx - leftIdx + 1;
//        return length - mostFrequency <= k;
//    }

    public int characterReplacement(String s, int k) {
        int[] freqArr = new int[26];
        int left = 0;
        int right  = left;
        char[] chars = s.toCharArray();
        int maxFreq = 0;
        int maxWindow = 0;
        for(int i = 0; i<chars.length;i++){
            freqArr[chars[i]-'A']++;
            if(freqArr[chars[i]-'A']>maxFreq)
                maxFreq = freqArr[chars[i]-'A'];

            if((i-left+1)-maxFreq<=k ){
                right = i;
                continue;
            } else {
                freqArr[chars[left]-'A']--;
                left++;
            }

            if(maxWindow < i-left+1)
                maxWindow = i-left+1;

        }
        if(maxWindow < right-left+1)
            maxWindow = right-left+1;
        return maxWindow;
    }
}
