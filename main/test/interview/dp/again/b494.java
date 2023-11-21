package interview.dp.again;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//记忆化搜索
public class b494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0,len=nums.length;
        for (int num:nums) {
            sum+=num;
        }
        if(sum<Math.abs(target)) return 0;
        int dp[][]=new int[len+1][2*sum+1];
        dp[0][sum]=1;
        for (int i = 1; i <=len ; i++) {
            for (int j =2*sum; j >=0 ; j--) {
                if(j-nums[i-1]>=0) dp[i][j]+=dp[i-1][j-nums[i-1]];
                if(j+nums[i-1]<=2*sum) dp[i][j]+=dp[i-1][j+nums[i-1]];
            }
        }
        return dp[len][target+sum];
    }

    @Test
    public void test(){
        System.out.println(findTargetSumWays(new int[]{0,0,0},0));
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1,0,0},3));
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1,1},3));
    }
}
