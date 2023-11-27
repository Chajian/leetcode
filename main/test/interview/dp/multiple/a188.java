package interview.dp.multiple;

import org.junit.Test;

public class a188 {
    public int maxProfit(int k, int[] prices) {

        int n = prices.length;
        k = 2*k-1;
        int[][]dp = new int[n][k];
        int max = 0;
        for(int i = 1 ; i < n ;i++){
            dp[i][0] = prices[i]-(prices[i-1]-dp[i-1][0]);
            dp[i][0] = dp[i][0]>0?dp[i][0]:0;
            for(int j = 1;j<k;j++){
                if(j%2==1){
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]+(prices[i]-prices[i-1]));
                }
            }
            if(dp[i][k-1]>max)
                max=dp[i][k-1];
        }
        return max;
    }

    @Test
    public void test(){
        System.out.println(maxProfit(2,new int[]{2,4,1}));
    }

    @Test
    public void test2(){
        System.out.println(maxProfit(2,new int[]{3,2,6,5,0,3}));
    }
}
