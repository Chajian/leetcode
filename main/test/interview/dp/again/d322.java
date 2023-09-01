package interview.dp.again;

import java.util.Arrays;

public class d322 {
    public int coinChange(int[] coins, int amount) {
        int[] ary = new int[amount+1];
        Arrays.fill(ary, Integer.MAX_VALUE);
        ary[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = coin; j <= amount; j++) {
                if (ary[j-coin] == Integer.MAX_VALUE) continue;
                ary[j] = Math.min(ary[j], ary[j-coin] +1);
            }
        }
        if (ary[amount] == Integer.MAX_VALUE) return -1;
        else return ary[amount];
    }
}
