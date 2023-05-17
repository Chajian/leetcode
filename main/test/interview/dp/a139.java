package interview.dp;

import org.junit.Test;

import java.util.*;

/**
 *
 * BFS+Memory
 */
public class a139 {
    Set<String> set;
    Stack<List<Integer>> stack;
    Map<Integer,Map<Integer,Boolean>> memory;
    int n,minle=999,maxlen=-1;
    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        set = new HashSet<>();
        stack = new Stack<>();
        memory = new HashMap<>();
        for(String s1:wordDict){
            set.add(s1);
            if(s1.length()>maxlen)
                maxlen = s1.length();
            if(s1.length()<minle)
                minle = s1.length();
        }
        if(bfs(s,0,1))
            return true;
        while(stack.size()>0){
            List<Integer> list = stack.pop();
            if(bfs(s,list.get(0),list.get(1)))
                return true;
        }
        return false;
    }


    public boolean bfs(String s,int start,int end){
        if(start==n)
            return true;
        if(end-start>maxlen||start>=n||end>n){
            return false;
        }
        if(memory.get(start)!=null&&memory.get(start).get(end)!=null)
            return memory.get(start).get(end);
        String s1 = s.substring(start,end);
        if(set.contains(s1)){
            stack.push(List.of(end,end+minle));
        }
        if(memory.get(start)==null)
            memory.put(start,new HashMap<>());
        boolean result = bfs(s,start,end+1);
        memory.get(start).put(end+1,result);
        return result;
    }



    @Test
    public void test(){
        boolean result = wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList(new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"}));
        System.out.println(result);
    }

}
