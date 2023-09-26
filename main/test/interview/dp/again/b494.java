package interview.dp.again;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//记忆化搜索
public class b494 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num:nums) {
            sum += num;
        }
        if(sum<Math.abs(target))return 0;
        int[][] dp = new int[nums.length+1][2*sum+1];
        dp[0][sum] = 1;
        for(int i = 0 ; i < nums.length;i++){
            for(int j = nums[i] ; j < 2*sum+1-nums[i];j++){
                if(dp[i][j]!=0) {
                    dp[i + 1][j + nums[i]] += dp[i][j];
                    dp[i + 1][j - nums[i]] += dp[i][j];
                }
            }
        }
        return dp[nums.length][sum+target];
    }

    @Test
    public void test(){
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1},3));
        System.out.println(findTargetSumWays(new int[]{1,0},1));
        System.out.println(findTargetSumWays(new int[]{1,0,0},1));
        System.out.println(findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,1},1));
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},0));
        System.out.println(findTargetSumWays(new int[]{100},-200));
    }




}
