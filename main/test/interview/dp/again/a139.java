package interview.dp.again;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class a139 {

    Set<String> set;
    int[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>();
        for(String word:wordDict)
            set.add(word);
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < s.length() ;i++){
            stringBuilder.append(chars[i]);
            if(dfs(chars,0,stringBuilder));
        }
        return false;
    }

    public boolean dfs(char[] chars,int start,StringBuilder stringBuilder){
        if(stringBuilder.length()>= chars.length)return false;
        int cur = set.contains(stringBuilder.toString())?stringBuilder.length():start;
        int len = stringBuilder.length();
        for(int i = start+1;i < chars.length;i++){
            stringBuilder.append(chars[i]);
            if(dfs(chars,start+1,stringBuilder))return true;
            if(set.contains(stringBuilder.substring(cur,i+1)))cur = i+1;
        }
        stringBuilder.delete(len,stringBuilder.length());
        return cur == chars.length;
    }


    @Test
    public void test(){
        System.out.println(wordBreak("aebbbbs",List.of("a","aeb","ebbbb","s","eb")));

    }


}
