package leetcode.medium;

import leetcode.easy.TreeNode;

public class DesignAddAndSearchWordsDataStructure {
    TrieNode trieNode;

    public DesignAddAndSearchWordsDataStructure() {
        trieNode = new TrieNode();
        trieNode.endOfTheWord = true;
    }

    public static void main(String args[]){

        DesignAddAndSearchWordsDataStructure d = new DesignAddAndSearchWordsDataStructure();
        d.addWord("bad");

        d.search("b..");

    }

    public void addWord(String word) {
        TrieNode curr = trieNode;
        for(char ch : word.toCharArray()){
            int k = ch-'a';
            if(curr.trieNodes[k] == null){
                curr.trieNodes[k] = new TrieNode();
            }
            curr = curr.trieNodes[k];
        }
        curr.endOfTheWord = true;
    }

    public boolean search(String word) {
        if(word == null || word.isEmpty() ){
            return  true;
        }
        return searchWithDots(word.toCharArray(), 0, trieNode);
    }

    public boolean searchWithDots(char[] word, int pos, TrieNode tn){
        if(tn == null) return false;
        if(pos == word.length) return tn.endOfTheWord;
        TrieNode curr = tn;
        for(int i = pos; i<word.length;i++) {
            if (word[i] == '.') {
                for (int j = 0; j < 26; j++) {
                    if (curr.trieNodes[j]!=null && searchWithDots(word, i + 1, curr.trieNodes[j])) {
                        return true;
                    }
                }
                return false;
            }
            if (curr.trieNodes[word[i] - 'a'] == null) {
                return false;
            } else
                curr = curr.trieNodes[word[i] - 'a'];
        }
        return curr.endOfTheWord;
    }
}
