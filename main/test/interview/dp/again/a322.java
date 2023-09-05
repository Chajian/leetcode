package interview.dp.again;

import org.junit.Test;

<<<<<<< HEAD
public class a322 {

    int res;
    int[] memory;

    public int coinChange(int[] coins, int amount) {
        res = Integer.MAX_VALUE;
        memory = new int[amount];
        sortDes(coins,0,coins.length-1);
        return dfs(coins,amount,0,0)==Integer.MAX_VALUE?-1:res;
    }

    public int dfs(int[] coins,int mount,int i,int time){
        if(mount < 0||i>=coins.length||time>=res||mount<0)
            return -1;
        if(mount==0) {
            res = Math.min(res,time);
            return time;
        }
        if(memory[mount-1]!=0)
            return memory[mount-1];
        dfs(coins,mount-coins[i],i,time+1);
        dfs(coins,mount-coins[i],i+1,time+1);
        dfs(coins,mount,i+1,time);
        memory[mount-1] = res;
        return memory[mount-1];
    }

    public void sortDes(int[] num,int i,int j){
        if(i>=j)
            return;
        int start = i,end = j,middle = num[i],middleI = start;
        while(start<end){
            while(start<end&&num[end]<middle)
                end--;
            num[start] = num[end];
            while(start<end&&num[start]>=middle)
                start++;
            num[end] = num[start];
        }
        num[start] = middle;
        sortDes(num,i,start-1);
        sortDes(num,start+1,j);
    }

    @Test
    public void test(){
        System.out.println(coinChange(new int[]{411,412,413,414,415,416,417,418,419,420,421,422},9864));
        System.out.println(coinChange(new int[]{1,2,5},11));
        System.out.println(coinChange(new int[]{186,419,83,408},6249));
    }

=======
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
>>>>>>> 0b91ff3fef0828212502be256d1fa019f4954f21
}
