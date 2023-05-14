package interview.dp;

public class a70 {
    public int climbStairs(int n) {
        short[] dp = new short[n+1];
        dp[0] = 1;dp[1] = 1;
        for(short i = 2; i <= n ;i++){
            dp[i] = (short) (dp[i-1]+dp[i-2]);
        }
        return dp[n];
    }
}
