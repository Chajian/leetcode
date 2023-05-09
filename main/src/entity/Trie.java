package entity;

import java.util.HashMap;

public class Trie {
    Trie[] tries;
    boolean isEnd = false;

    public Trie() {
        tries = new Trie[26];
    }

    public void insert(String word) {
        Trie cur = this;
        for(int i = 0 ; i < word.length() ;i++){
            char c = word.charAt(i);
            if(cur.tries[c-'a']==null)
                cur.tries[c-'a'] = new Trie();
            cur = cur.tries[c-'a'];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        Trie cur = this;
        for(int i = 0 ; i < word.length();i++){
            char c = word.charAt(i);
            if(cur.tries[c-'a']==null)
                return false;
            cur = cur.tries[c-'a'];
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie cur = this;
        for(int i = 0 ; i < prefix.length();i++){
            char c = prefix.charAt(i);
            if(cur.tries[c-'a']==null)
                return false;
            cur = cur.tries[c-'a'];
        }
        return true;
    }
}
