package interview.dp;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class a416 {
    public boolean canPartition(int[] nums) {
        int target = 0;
        for(int i = 0 ; i < nums.length ;i++){
            target+=nums[i];
        }
        if(target%2==1)
            return false;
        else
            target/=2;
        int[][]dp = new int[nums.length][target+1];
        //init
        for(int i = 0 ; i <= target ;i++){
            if(i<nums[0]){
                dp[0][i] =0;
            }
            else{
                dp[0][i] = nums[0];
            }
        }
        for(int i = 1; i < nums.length ;i++){
            for(int j = 1 ; j <= target&&dp[i][j]<=target;j++){
                dp[i][j] = Math.max(dp[i-1][j],j-nums[i]>=0?dp[i-1][j-nums[i]]+nums[i]:0);
            }
        }
        return dp[nums.length-1][target]==target;
    }

    @Test
    public void test(){
        System.out.println(canPartition(new int[]{1,2,3,5}));
    }
}
