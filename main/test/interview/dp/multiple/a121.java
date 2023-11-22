package interview.dp.multiple;

import org.junit.Test;

public class a121 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        int max = 0;
        for(int i = n-2 ; i >=0 ;i--){
            int profit = prices[i+1]+dp[i+1]-prices[i];
            if(profit>0)
                dp[i]=profit;
            if(dp[i]>max)
                max = dp[i];
        }
        return max;
    }

    @Test
    public void test(){
        int[] info = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(info));
    }
}
