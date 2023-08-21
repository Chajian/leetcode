package interview.dp.again;

import org.junit.Test;

/**
 * dp
 * dp[i] = dp[i-1]+dp[i-2]
 */
public class b70 {
    int[] dp;
    public int climbStairs(int n){
        if(n<4)return n;
        dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2 ; i < n ;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }

    @Test
    public void test(){
        System.out.println(climbStairs(5));
    }
}
