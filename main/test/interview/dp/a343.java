package interview.dp;

public class a343 {
    int[] dp;
    public int integerBreak(int n) {
        dp = new int[n<6?6:n];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 6;
        dp[5] = 9;


        for(int i = 6 ; i < n ; i++){
            dp[i] = 3*dp[i-3];
        }
        return dp[n-1];
    }
}
