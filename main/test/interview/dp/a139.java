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
        for(String ss:wordDict){
            set.add(ss);
        }
        dp[0] = true;
        for(int i = 1; i <= n;i++){
            for(int j = 0; j < i&&!dp[i];j++) {
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
