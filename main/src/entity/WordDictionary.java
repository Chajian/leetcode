package entity;

public class WordDictionary {
    WordDictionary[] map;
    boolean isEnd;

    public WordDictionary() {
        map = new WordDictionary[26];
        isEnd = false;
    }

    public void addWord(String word) {
        WordDictionary cur = this;
        for(int i = 0 ; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.map[c-'a']==null)
                cur.map[c-'a'] = new WordDictionary();
            cur = cur.map[c-'a'];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        return Mysearch(word,this);
    }

    public boolean Mysearch(String word,WordDictionary dictionary){
        if(dictionary==null)
            return false;
        WordDictionary cur = dictionary;
        for(int i = 0 ; i < word.length() ;i++){
            char c = word.charAt(i);
            if(cur==null||(c!='.'&&cur.map[c-'a']==null))
                return false;
            if(c=='.'){
                if(map.length==0)return false;
                String newWord = word.substring(i+1,word.length());
                boolean resbrnch = false;
                for(WordDictionary wordDictionary:cur.map)
                    resbrnch |= Mysearch(newWord,wordDictionary);
                return resbrnch;
            }
            cur = cur.map[c-'a'];
        }
        return cur.isEnd;
    }
}
