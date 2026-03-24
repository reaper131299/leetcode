package leetcode.hard;

import java.util.*;

public class WordLadder {

    public static void main(String args[]){
        WordLadder w = new WordLadder();
        System.out.println(w.ladderLength("hit", "cog", List.of("hot","dot","dog","lot","log")));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue  = new ArrayDeque<>();
        int length = 0;
        queue.add(beginWord);
        set.remove(beginWord);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;  i<size; i++){

                String word = queue.poll();
                if(endWord.equals(word)){
                    return length+1;
                }
                char[] chars = word.toCharArray();
                for(int p = 0; p<word.length(); p++){
                    char chatAtP = chars[p];
                    for(int c = 97; c<=122; c++){
                        chars[p] = (char) c;
                        String possibleNextWord = new String(chars);
                        if(set.contains(possibleNextWord)) {
                            queue.add(possibleNextWord);
                            set.remove(possibleNextWord);
                        }
                    }
                    chars[p] = chatAtP;
                }
            }
            length++;
        }
        return 0;
    }
}
