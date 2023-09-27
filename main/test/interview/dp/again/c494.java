package interview.dp.again;

import org.junit.Test;

public class c494 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num:nums) {
            sum += num;
        }
        int offset = sum;
        if(sum<Math.abs(target))return 0;
        sum = 2*sum+1;
        int[] dp = new int[sum];
        dp[offset] = 1;
        for(int i = 0 ; i < nums.length;i++){
            int[] temp = new int[sum];
            for(int j = 0 ; j < sum-nums[i];j++){
                if(dp[j]!=0) {
                    temp[j + nums[i]] += dp[j];
                    temp[j - nums[i]] += dp[j];
                }
            }
            dp = temp;

        }
        return dp[offset+target];
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
