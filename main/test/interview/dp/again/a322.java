package interview.dp.again;

import org.junit.Test;

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

}
