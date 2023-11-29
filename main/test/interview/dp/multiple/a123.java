package interview.dp.multiple;

import org.junit.Test;

public class a123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][]dp = new int[n][3];
        int max = 0;
        for(int i = 1 ; i < n ;i++){
            dp[i][0] = prices[i]-(prices[i-1]-dp[i-1][0]);
            dp[i][0] = dp[i][0]>0?dp[i][0]:0;
            dp[i][1] = Math.max(dp[i][0],dp[i-1][1]);
            dp[i][2] = Math.max(dp[i][1],dp[i-1][2]+prices[i]-prices[i-1]);
            if(dp[i][2]>max)
                max=dp[i][2];
        }
        return max;
    }

    @Test
    public void test(){
        System.out.println(maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }

    @Test
    public void test2(){
        System.out.println(maxProfit(new int[]{2,1,4,5,2,9,7}));
    }


}
