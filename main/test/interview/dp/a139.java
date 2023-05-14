package interview.dp;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class a139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        HashSet<String> set = new HashSet<>();
        int n = s.length();
        int maxWorld = 0;
        int minWorld = 999;
        for(String ss:wordDict){
            set.add(ss);
            if(ss.length()>maxWorld)
                maxWorld = ss.length();
            if(ss.length()<minWorld)
                minWorld = ss.length();
        }


        dp[0] = true;
        for(int i = 1; i <= n;i++){
            for(int j = i<=maxWorld?0:i-maxWorld; j <= i-minWorld&&!dp[i];j++) {
                String sub = s.substring(j, i);
                if (set.contains(sub)) dp[i] = dp[j];
            }
            if(dp[n])
                return true;
        }
        return false;
    }

    @Test
    public void test(){
        System.out.println(wordBreak("aaaaaaa", Arrays.asList(new String[]{"aaaa","aaa"})));
    }

}
