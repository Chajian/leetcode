package interview.dp;

import org.junit.Test;

import java.util.*;

/**
 * DFS时间复杂度过高
 * 加上记忆回溯试试
 */
public class a139 {
    HashSet<String> set = new HashSet<>();
    int maxlen = -1,minlen = 999;
    StringBuilder stringBuilder = new StringBuilder();
    Map<Integer,Map<String,Boolean>> memory = new HashMap<>();
    // DFS
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] visited = new boolean[s.length()];
        for(String s1:wordDict){
            set.add(s1);
            if(s1.length()>maxlen)
                maxlen = s1.length();
            if(s1.length()<minlen)
                minlen = s1.length();
        }
        return dfs(s,0,visited);
    }

    public boolean dfs(String s,int index,boolean[] visited){
        if(index==s.length()&&visited[s.length()-1])
            return true;
        if(index>=s.length()||stringBuilder.length()>maxlen)
            return false;
        if(memory.get(index)!=null&&memory.get(index).get(stringBuilder.toString())!=null){
            return memory.get(index).get(stringBuilder.toString());
        }

        if(memory.get(index)==null)
            memory.put(index,new HashMap<>());
        stringBuilder.append(s.charAt(index));
        boolean result = false;
        String cache = "";
        if(set.contains(stringBuilder.toString())){
            visited[index] = true;
            cache = stringBuilder.toString();
            stringBuilder.delete(0,stringBuilder.length());
            result = dfs(s,index+1,visited);
            memory.get(index).put(stringBuilder.toString(),result);
            if(result)
                return true;
        }
        stringBuilder.append(cache);
        result = dfs(s,index+1,visited);
        memory.get(index).put(stringBuilder.toString(),result);
        visited[index] = false;
        if(stringBuilder.length()>0)
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return result;
    }




    @Test
    public void test(){
        boolean result = wordBreak("leetcode", Arrays.asList(new String[]{"leet","code"}));
        System.out.println(result);
    }

}
