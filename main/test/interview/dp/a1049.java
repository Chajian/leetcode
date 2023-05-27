package interview.dp;

import org.junit.Test;

import java.util.*;

public class a1049 {
    int dp[][];
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int i = 0 ; i < stones.length ;i++){
            sum+=stones[i];
        }
        dp = new int[stones.length][sum+1];
        int target =sum/2;
            return Math.abs(sum-2*add(stones,0,0,target));
    }

    public int add(int[] stones,int i,int num,int target){
        if(i>=stones.length||num==target)
            return num;

        int next = 0,source = 0;
        if(dp[i][num+stones[i]]==0){
            next = add(stones, i + 1, num + stones[i], target);
            dp[i][num+stones[i]] = next;
        }
        else
            next = dp[i][num+stones[i]];
        if(dp[i][num]==0){
            source = add(stones, i + 1, num, target);
            dp[i][num] = source;
        }
        else
            source = dp[i][num];

        if(Math.abs(target-next)<=Math.abs(target-source))
            return next;
        return source;
    }

    @Test
    public void test(){
        System.out.println(lastStoneWeightII(new int[]{1,1,3}));
    }
}
