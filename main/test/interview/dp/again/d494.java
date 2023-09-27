package interview.dp.again;

import org.junit.Test;

public class d494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum =0,n = nums.length+1;
        for(int num:nums)
            sum+=num;
        int[][] dp = new int[n][sum+1];
        int offset = sum;
        sum = target+sum;
        int N = sum/2;
        if(sum%2==1||sum<0||N>offset)
            return 0;
        dp[0][0]=1;
        for(int i = 0 ; i <nums.length;i++){
            for(int j = 0 ; j <=(offset-nums[i]);j++){
                if(dp[i][j]!=0) {
                    dp[i + 1][j] += dp[i][j];
                    dp[i + 1][j + nums[i]] += dp[i][j];
                }
            }
        }
        return dp[nums.length][N];
    }

    @Test
    public void test(){
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1},3));
        System.out.println(findTargetSumWays(new int[]{1,0},1));
        System.out.println(findTargetSumWays(new int[]{1,0,0},1));
        System.out.println(findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,1},1));
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},0));
        System.out.println(findTargetSumWays(new int[]{100},-200));
        System.out.println(findTargetSumWays(new int[]{2,107,109,113,127,131,137,3,2,3,5,7,11,13,17,19,23,29,47,53},1000));

    }
}
