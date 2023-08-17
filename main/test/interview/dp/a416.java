package interview.dp;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class a416 {
    int[] dp;
    public boolean canPartition(int[] nums) {
        int target = 0;
        for(int i = 0 ; i < nums.length ;i++){
            target+=nums[i];
        }
        if(target%2==1)
            return false;
        else
            target/=2;
        dp = new int[target+1];
        for(int i = 0 ; i < nums.length ;i++){
            for(int j = target ; j >= nums[i];j--)
                dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);
        }
        return dp[target]==target;
    }

    @Test
    public void test(){
        System.out.println(canPartition(new int[]{14,9,8,4,3,2}));
    }
}
