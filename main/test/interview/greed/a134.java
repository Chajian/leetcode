package interview.dp;

import org.junit.Test;

public class a134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        gas[0] = gas[0]-cost[0];
        cost[0] =gas[0];
        int current = gas[0],currentOn = 0;
        for(int i = 1 ; i < n;i++){
            gas[i] = gas[i]-cost[i];
            if(current<=0) {
                current = gas[i];
                currentOn = i;
            }
            else
                current +=gas[i];

            cost[i]=cost[i-1]+gas[i];
        }
        if(current<0)
            return -1;
        if(currentOn==0)
            return currentOn;
        if((current+cost[currentOn-1])>=0)
            return currentOn;
        return -1;
    }

    @Test
    public void test(){
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2}));
    }

    @Test
    public void test1(){
        System.out.println(canCompleteCircuit(new int[]{3,3,4},new int[]{3,4,3}));
    }

    @Test
    public void test2(){
        System.out.println(canCompleteCircuit(new int[]{3,1,1},new int[]{1,2,2}));
    }
}
