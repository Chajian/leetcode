package interview.dp;

import org.junit.Test;

import java.util.*;

public class a322 {

    int res = Integer.MAX_VALUE;
    Map<Integer,Map<Integer,Integer>> memory;
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        memory = new HashMap<>();

        findWay(coins,amount,0);

        // 如果没有任何一种硬币组合能组成总金额，返回 -1。
        if(res == Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }

    public void findWay(int[] coins,int amount,int count){
        if(amount < 0){
            return;
        }
        if(amount == 0){
            res = Math.min(res,count);
            if(memory.get(amount)==null)
                memory.put(amount,new HashMap<>());
            memory.get(amount).put(count,res);
        }
        if(memory.get(amount)!=null&&memory.get(amount).get(count)!=null) {
            res = memory.get(amount).get(count);
            return;
        }

        for(int i = 0;i < coins.length;i++){
            findWay(coins,amount-coins[i],count+1);
        }
    }


    @Test
    public void test(){
        System.out.println(coinChange(new int[]{1,2,5},11));
    }
}
