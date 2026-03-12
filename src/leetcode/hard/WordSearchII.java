package leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

    TrieNode trieNode;

    /*
    to solve this problem we can use trie node like previous problems with array or with hash map
    we will be using hash map for better performance as we will be removing the child nodes from parent's hashmap if the child's hash map is empty.
     */
    public static void main(String args[]){
        char[][] board = {{'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}};

        String[] words = new String[]{"oath","pea","eat","rain"};

        WordSearchII w = new WordSearchII();
        w.findWords(board, words);

    }

    public List<String> findWords(char[][] board, String[] words) {
        trieNode = new TrieNode();

        for (String word : words){
            addWord(word);
        }

        Set<String> res = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0; i< board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                find(res, i, j, trieNode, visited, board);
            }
        }
        return new ArrayList<>(res);
    }

    public void addWord(String word){
        TrieNode curr = trieNode;
        char[] chars = word.toCharArray();
        for (char ch : chars){
            if(!curr.trieNodes.containsKey(ch)) {
                curr.trieNodes.put(ch, new TrieNode());
            }
            curr = curr.trieNodes.get(ch);
        }
        curr.endOfTheWord = true;
        curr.word = word;
    }

    public void find(Set<String> res, int i, int j, TrieNode tn, boolean[][] visited, char[][] board){
        if(i<0 || j<0 || i>= board.length || j>=board[0].length || visited[i][j] || tn.trieNodes.get(board[i][j]) == null) return;

        TrieNode curr = tn.trieNodes.get(board[i][j]);
        visited[i][j] = true;

        find(res, i+1, j, curr, visited, board);
        find(res, i, j+1, curr, visited, board);
        find(res, i-1, j, curr, visited, board);
        find(res, i, j-1, curr, visited, board);

        if(curr.endOfTheWord) {
            res.add(curr.word);
            curr.endOfTheWord = false;
        }
        if(curr.trieNodes.isEmpty()) {
            tn.trieNodes.remove(board[i][j]);
        }

        visited[i][j] = false;
    }
}
