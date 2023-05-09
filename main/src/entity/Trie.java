package entity;

import java.util.HashMap;

public class Trie {
    TreeNodeChar root;

    public Trie() {
        root = new TreeNodeChar('/');
    }

    public void insert(String word) {
        word+='.';
        TreeNodeChar cur = root.left,pre = root;
        for(char c : word.toCharArray()){
            if(cur==null){
                pre.left = new TreeNodeChar(c);
                pre = pre.left;
                cur = pre.left;
                continue;
            }
            while(cur!=null&&cur.val!=c){
                pre = cur;
                cur = cur.right;
            }
            if(cur==null){
                pre.right = new TreeNodeChar(c);
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
        TreeNodeChar cur = root.left;

        for(char c : prefix.toCharArray()){
            while(cur!=null && cur.val != c){
                cur = cur.right;
            }
            if(cur == null)
                return false;
            cur = cur.left;
        }
        return true;
    }
}
