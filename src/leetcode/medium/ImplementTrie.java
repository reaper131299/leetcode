package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;

public class ImplementTrie {

    TrieNode trieNode;

    public static void main(String args[]){
        ImplementTrie i = new ImplementTrie();
        i.insert("sap");
        i.insert("saped");
        i.insert("porn");
        i.search("sa");
        i.search("po");
        i.search("porn");
        i.startsWith("sa");
        i.startsWith("po");
        i.startsWith("porn");
        i.startsWith("pornz");
    }

    public ImplementTrie() {
        trieNode = new TrieNode();
        trieNode.endOfTheWord = true;
    }

    public void insert(String word) {
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
        TrieNode curr = trieNode;
        for(char ch :  word.toCharArray()){
            int k = ch-'a';
            if(curr.trieNodes[k] == null) return false;
            else curr = curr.trieNodes[k];
        }
        return curr.endOfTheWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = trieNode;
        for(char ch : prefix.toCharArray()){
            int k = ch-'a';
            if(curr.trieNodes[k] == null) return false;
            else curr = curr.trieNodes[k];
        }
        return true;
    }
}
