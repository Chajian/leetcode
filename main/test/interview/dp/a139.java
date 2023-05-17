package interview.dp;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class a139 {
    HashSet<String> set = new HashSet<>();
    int maxlen = -1,minlen = 999;
    StringBuilder stringBuilder = new StringBuilder();
    // DFS
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] visited = new boolean[s.length() + 1];
        stringBuilder.append(s);
        for(String s1:wordDict){
            set.add(s1);
            if(s1.length()>maxlen)
                maxlen = s1.length();
            if(s1.length()<minlen)
                minlen = s1.length();
        }
        return dfs(s,0,wordDict,visited);
    }

    public boolean dfs(String s,int index,List<String> wordDict,boolean[] visited){
        if(index==s.length()&&visited[s.length()])
            return true;
        if(index>s.length()||stringBuilder.length()>maxlen)
            return false;
        stringBuilder.append(s.charAt(index));
        boolean result = false;
        String cache = stringBuilder.toString();
        if(set.contains(stringBuilder.toString())){
            visited[index] = true;
            stringBuilder.delete(0,stringBuilder.length());
            if(dfs(s,index+1,wordDict,visited))
                return true;
        }
        stringBuilder.append(cache);
        result = dfs(s,index+1,wordDict,visited);
        visited[index] = false;
        return result;
    }




    @Test
    public void test(){
        boolean result = wordBreak("aebbbbs", Arrays.asList(new String[]{"a","aeb","ebbbb","s","eb"}));
        System.out.println(result);
    }

}
