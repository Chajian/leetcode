package interview.dp.again;

import org.junit.Test;

import java.util.Arrays;

public class c322 {


    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] memory = new int[amount+1];
        memory[0] = 0;
        for(int i = 1 ; i <= amount ;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length ;j++){
                if(i-coins[j]<0)
                    break;
                min = memory[i-coins[j]]>=0?Math.min(min,memory[i-coins[j]]):min;
            }
            memory[i] = min==Integer.MAX_VALUE?-1:min+1;
        }
        return memory[amount];
    }


    @Test
    public void test(){
        System.out.println(coinChange(new int[]{411,412,413,414,415,416,417,418,419,420,421,422},9864));
        System.out.println(coinChange(new int[]{1,2,5},11));
        System.out.println(coinChange(new int[]{186,419,83,408},6249));
        System.out.println(coinChange(new int[]{2},3));
    }
}
