package interview.dp.again;

import org.junit.Test;

public class b322 {
    int[] memory;
    public int coinChange(int[] coins, int amount) {
        memory = new int[amount];
        return bfs(coins,amount);
    }

    public int bfs(int[] coins,int mount){
        if(mount <0)
            return -1;
        if(mount==0){
            return 0;
        }
        if(memory[mount-1]!=0)
            return memory[mount-1];
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < coins.length ;i++){
            int res = bfs(coins,mount-coins[i]);
            if(res>=0&&min>res){
                min = res;
            }
        }
        memory[mount-1] = (min==Integer.MAX_VALUE?-1:min+1);
        return memory[mount-1];
    }

    @Test
    public void test(){
        System.out.println(coinChange(new int[]{411,412,413,414,415,416,417,418,419,420,421,422},9864));
        System.out.println(coinChange(new int[]{1,2,5},11));
        System.out.println(coinChange(new int[]{186,419,83,408},6249));
    }
}
