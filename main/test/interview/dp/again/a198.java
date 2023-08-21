package interview.dp.again;

public class a198 {
    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2 ; i < dp.length ;i++){
            dp[i] = nums[i-1]+dp[i-2] < dp[i-1]?dp[i-1]:nums[i-1]+dp[i-2];
        }
        return dp[dp.length-1];
    }


    public void test(){

    }
}
