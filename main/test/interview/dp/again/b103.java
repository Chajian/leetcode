package interview.dp.again;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 暴力
 */
public class b103 {
    int[][] dp;
    int res;
    public int coinChange(int[] coins, int amount) {
        //quick sort
//        sort(coins,0,coins.length-1);
        res = Integer.MAX_VALUE;
        dp = new int[amount][100];
        return calcula(coins,0,amount,0);
    }
    public int calcula(int[] coins,int i,int mount,int time){
        if(i>=coins.length||mount<0||time>=50||time>=res){
            return -1;
        }
        if(mount==0) {
            res = Math.min(res,time);
            return time;
        }
        if(dp[mount-1][time]!=0)
            return dp[mount-1][time];

        int min = Integer.MAX_VALUE;
        int tres = calcula(coins,i+1,mount,time);//bfs
        min = tres>=0?Math.min(tres,min):min;
        if(mount-coins[i]>=0) {;//dfs
            tres = calcula(coins, i, mount - coins[i],time+1);//接着选择自己
            min = tres>=0?Math.min(tres,min):min;
            tres = calcula(coins,i+1,mount-coins[i],time+1);//dfs
            min = tres>=0?Math.min(tres,min):min;
        }
        dp[mount-1][time] = min==Integer.MAX_VALUE?-1:min;
        return dp[mount-1][time];
    }



    //quick sort
    public void sort(int[] coins,int i,int j){
        if(i>=j)return;
        int left = i,right = j,middle = left,m = coins[left];
        while(left<right){
            while(left<right&&coins[right]<m)
                right--;
            coins[middle] = coins[right];
            middle = right;
            while(left<right&&coins[left]>=m)
                left++;
            coins[middle] = coins[left];
            middle = left;
        }
        coins[middle] = m;
        sort(coins,i,middle-1);
        sort(coins,middle+1,j);
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
