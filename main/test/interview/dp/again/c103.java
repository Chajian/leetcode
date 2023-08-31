package interview.dp.again;

import org.junit.Test;

public class c103 {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount];
        return bfs(coins,amount);
    }

    public int bfs(int[] coins,int amount){
        if(amount ==0)return 0;
        if(dp[amount-1]!=0)
            return dp[amount-1];
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < coins.length ;i++){
            if(amount-coins[i]<0)
                continue;
            int res = bfs(coins,amount-coins[i]);
            if(res >=0&& res<min)
                min = res;
        }
        dp[amount-1] = min==Integer.MAX_VALUE?-1:min+1;
        return dp[amount-1];
    }


    @Test
    public void test2(){

        System.out.println(coinChange(new int[]{1, 2, 5},11));
        System.out.println(coinChange(new int[]{2},3));
        System.out.println(coinChange(new int[]{1},0));
        System.out.println(coinChange(new int[]{1},1));
        System.out.println(coinChange(new int[]{1},2));

        System.out.println(coinChange(new int[]{186,419,83,408},6249));
        System.out.println(coinChange(new int[]{3,7,405,436},8839));
        System.out.println(coinChange(new int[]{411,412,413,414,415,416,417,418,419,420,421,422},9864));
    }

}
