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
            int c = word.charAt(i)-'a';
            if(cur.map[c]==null)
                cur.map[c] = new WordDictionary();
            cur = cur.map[c];
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
            int c = word.charAt(i)-'a';
            if(cur==null||(c!=-51&&cur.map[c]==null))
                return false;
            if(c==-51){
                String newWord = word.substring(i+1,word.length());
                for(WordDictionary wordDictionary:cur.map)
                    if(Mysearch(newWord,wordDictionary))return true;
                return false;
            }
            cur = cur.map[c];
        }
        return cur.isEnd;
    }
}
