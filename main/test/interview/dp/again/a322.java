package interview.dp.again;

import org.junit.Test;

import java.util.Arrays;

public class a322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[(amount+1)];
        Arrays.sort(coins);
        dp[0]=0;
        for(int j = 1 ; j < coins[0];j++)
            dp[j]=-1;
        for(int i = coins[0] ; i <= amount ;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0 ; j < coins.length ;j++){
                if(i - coins[j]<0)
                    break;
                if(dp[i-coins[j]]>=0)
                    min = Math.min(dp[i-coins[j]],min);
            }
            dp[i] = min == Integer.MAX_VALUE?-1:min+1;
        }
        return dp [amount];
    }

    @Test
    public void test2(){

        System.out.println(coinChange(new int[]{1, 2, 5},11));
        System.out.println(coinChange(new int[]{2},3));
        System.out.println(coinChange(new int[]{1},0));
        System.out.println(coinChange(new int[]{1},1));
        System.out.println(coinChange(new int[]{1},2));
        System.out.println(coinChange(new int[]{2},3));

        System.out.println(coinChange(new int[]{186,419,83,408},6249));
        System.out.println(coinChange(new int[]{3,7,405,436},8839));
        System.out.println(coinChange(new int[]{411,412,413,414,415,416,417,418,419,420,421,422},9864));
    }
}
