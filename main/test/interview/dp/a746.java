package interview.dp;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//liuyubobobo
public class a746 {
    Map<Integer,Integer> memory = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        return move(cost.length,cost);
    }

    public int move(int n,int[]cost){
        if(n==0||n==1)return 0;
        if(memory.get(n)!=null)
            return memory.get(n);
        int result = Math.min((cost[n-1]+move(n-1,cost)),(cost[n-2]+move(n-2,cost)));
        memory.put(n,result);
        return result;
    }

    @Test
    public void test(){
        System.out.println(minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}
