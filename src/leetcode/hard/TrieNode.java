package leetcode.hard;

import java.util.HashMap;

public class TrieNode {
    public boolean endOfTheWord;
    public HashMap<Character, TrieNode> trieNodes = new HashMap<>();
    public String word;
}
