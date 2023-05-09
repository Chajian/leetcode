package entity;

import java.util.HashMap;

public class Trie {
    TreeNodeChar root;
    HashMap<String,Integer> map;

    public Trie() {
        root = new TreeNodeChar('/');
        map = new HashMap<>();
    }

    public void insert(String word) {
        map.put(word,1);
        TreeNodeChar cur = root;
        for(char c : word.toCharArray()){
            while(cur.right!=null&&cur.right.val!=c){
                cur = cur.right;
            }
            if(cur.right==null){
                cur.left = new TreeNodeChar(c);
                cur = cur.left;
            }
        }
    }


    public boolean search(String word) {
        return map.get(word)!=null;
    }

    public boolean startsWith(String prefix) {
        TreeNodeChar cur = root;

        for(char c : prefix.toCharArray()){
            while(cur.right!=null&&cur.right.val!=c){
                cur = cur.right;
            }
            if(cur.left==null||cur.left.val != c){
                return false;
            }
            cur = cur.left;
        }
        return true;
    }
}
