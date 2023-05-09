package entity;

import java.util.HashMap;

public class Trie {
    char val;
    Trie left;
    Trie right;

    public Trie() {

    }

    public Trie(char val){
        this.val = val;
    }

    public void insert(String word) {
        Trie pre = this,cur = this.left;
        for(int i = 0 ; i < word.length() ;i++){
            char c = word.charAt(i);
            if(cur == null) {
                pre.left = new Trie(c);
                pre = pre.left;
                continue;
            }
            while(cur != null && cur.val != c){
                pre = cur;
                cur = cur.right;
            }
            if(cur == null){
                pre.right = new Trie(c);
                cur = pre.right;
            }
            pre = cur;
            cur = cur.left;
        }
    }

    public boolean search(String word) {
        word+='.';
        return startsWith(word);
    }

    public boolean startsWith(String prefix) {
        Trie cur = this.left;
        for(int i = 0 ; i < prefix.length();i++){
            char c = prefix.charAt(i);
            while(cur!=null&&cur.val!=c)
                cur = cur.right;
            if(cur == null)
                return false;
            cur = cur.left;
        }
        return true;
    }
}
