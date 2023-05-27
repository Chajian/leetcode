package interview.dp;

import org.junit.Test;

import java.util.*;

public class a1049 {
    int dp[];
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int i = 0 ; i < stones.length ;i++){
            sum+=stones[i];
        }
        int target =sum/2;
        dp = new int[target+1];
        for(int i = 0 ; i < stones.length ;i++){
            for(int j = target ; j>= stones[i] ;j--){
                dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return sum-2*dp[target];
    }

    @Test
    public void test(){
        System.out.println(lastStoneWeightII(new int[]{1,1,3}));
    }
}
