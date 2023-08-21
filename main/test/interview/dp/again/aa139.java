package interview.dp.again;

import org.junit.Test;

import java.util.*;

public class aa139 {
    Set<String> set;
    Map<Integer, Map<Integer,Boolean>> memory;

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>();
        memory = new HashMap<>();
        for(String word:wordDict)
            set.add(word);




        return f(s,0,0);

    }

    public boolean f(String s,int i,int j){
        if(i>=s.length()||j>=s.length())
            return false;
        if(memory.get(i)==null)
            memory.put(i,new HashMap<>());
        if(memory.get(i).get(j)!=null)
            return memory.get(i).get(j);

        if(set.contains(s.substring(i,j+1))){
            if(j==s.length()-1)
                return true;
            if(memory.get(j+1)==null)
                memory.put(j+1,new HashMap<>());
            boolean result = f(s,j+1,j+1);
            memory.get(j+1).put(j+1,result);
            if (result)return true;
        }
        boolean result = f(s,i,j+1);
        memory.get(i).put(j+1,result);
        return result;
    }

    @Test
    public void test(){
        System.out.println(wordBreak("leetcode",List.of(new String[]{"leet","code"})));
        System.out.println(wordBreak("applepenapple",List.of(new String[]{"apple", "pen"})));
        System.out.println(wordBreak("catsandog",List.of(new String[]{"cats", "dog", "sand", "and", "cat"})));
        System.out.println(wordBreak("aaaaaaa",List.of(new String[]{"aaaa", "aaa"})));
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",List.of(new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"})));
    }

}
