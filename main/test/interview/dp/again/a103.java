package interview.dp.again;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class a103 {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        //quick sort
        dp = new int[coins.length];
        Arrays.fill(dp,Integer.MIN_VALUE);
        calcula(coins,0,amount,0);
        sort(dp,0,dp.length-1);
        for(int i = dp.length-1;i>=0 ;i--)
            if(dp[i]>=0)
                return dp[i];
        return -1;
    }
//
    public void calcula(int[] coins,int i,int mount,int time){
        if(i>=coins.length){
            return;
        }
        if(mount==0) {
            if(dp[i]<0)
                dp[i] = time;
            else
                dp[i] = dp[i]>time?time:dp[i];
        }
        if(mount-coins[i]>=0) {;//选
            calcula(coins, i, mount - coins[i],time+1);//接着选择自己
            calcula(coins,i+1,mount-coins[i],time+1);//dfs
        }
        calcula(coins,i+1,mount,time);//不选
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
    public void test(){
        int[] nums = new int[]{};
        sort(nums,0,nums.length-1);
        for(int i = 0 ; i < nums.length ;i++)
            System.out.print(nums[i]+",");
        Arrays.sort(nums);
        System.out.println();
        System.out.println(Arrays.toString(nums));
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
    }
}
