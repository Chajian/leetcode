package everyday;

import org.junit.Test;

public class a1599 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int increat=0,curmember = 0,n = customers.length,flat = 0,max=0;
        for(int i =0;i<n;i++){
            curmember+=customers[i];
            increat+=customers[i];
            curmember-=Math.min(4,curmember);
            flat++;
        }
        flat += Math.ceil( curmember/4.0);
        max = increat*boardingCost-flat*runningCost;
        return max>=0?flat:-1;
    }

    @Test
    public void test(){
        System.out.println(minOperationsMaxProfit(new int[]{10,10,6,4,7},6,4));
    }
}
