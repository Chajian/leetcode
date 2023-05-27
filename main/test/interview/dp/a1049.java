package interview.dp;

import org.junit.Test;

import java.util.*;

public class a1049 {
    Map<Integer,Map<Integer,Integer>> memory = new HashMap<>();
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int i = 0 ; i < stones.length ;i++){
            sum+=stones[i];
        }
        int target =sum/2;
            return Math.abs(sum-2*add(stones,0,0,target));
    }

    public int add(int[] stones,int i,int num,int target){
        if(i>=stones.length)
            return num;

        if(memory.get(i)==null)
            memory.put(i,new HashMap<>());
        int next = 0,source = 0;
        if(memory.get(i).get(num+stones[i])==null) {
            next = add(stones, i + 1, num + stones[i], target);
            memory.get(i).put(num+stones[i],next);
        }
        else
            next = memory.get(i).put(num+stones[i],next);

        if(memory.get(i).get(num)==null) {
            source = add(stones, i + 1, num, target);
            memory.get(i).put(num,source);
        }
        else
            source = memory.get(i).put(num,next);

        if(Math.abs(target-next)<=Math.abs(target-source))
            return next;
        return source;
    }

    @Test
    public void test(){
        System.out.println(lastStoneWeightII(new int[]{1,1,3}));
    }
}
