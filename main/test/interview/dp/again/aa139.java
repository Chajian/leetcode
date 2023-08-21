package interview.dp.again;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class aa139 {
    Set<String> set;

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>();
        for(String word:wordDict)
            set.add(word);
        return f(s,0,0);

    }

    public boolean f(String s,int i,int j){
        if(i>=s.length()||j>=s.length())
            return false;

        if(set.contains(s.substring(i,j+1))){
            if(j==s.length()-1)
                return true;
            if (f(s,j+1,j+1))return true;
        }
        return f(s,i,j+1);
    }

    @Test
    public void test(){
//        System.out.println(wordBreak("leetcode",List.of(new String[]{"leet","code"})));
//        System.out.println(wordBreak("applepenapple",List.of(new String[]{"apple", "pen"})));
//        System.out.println(wordBreak("catsandog",List.of(new String[]{"cats", "dog", "sand", "and", "cat"})));
        System.out.println(wordBreak("aaaaaaa",List.of(new String[]{"aaaa", "aaa"})));
    }

}
