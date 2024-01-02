package interview.dp;

import org.junit.Test;

public class a1599 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int flat = 0,curcustomers = 0,n=customers.length,max=0,i=0,curprofit = 0;
        while(i<n||curcustomers>0){
            if(i<n) {
                curcustomers += customers[i];
            }
            int temp = Math.min(4,curcustomers);
            curcustomers-=temp;
            curprofit+=temp*boardingCost-runningCost;
            if(curprofit>max){
                max=curprofit;
                flat = i+1;
            }
            i++;
        }
        return max>0?flat:-1;
    }

    @Test
    public void test(){
        System.out.println(minOperationsMaxProfit(new int[]{10,10,6,4,7},3,8));
    }

    @Test
    public void test2(){
        System.out.println(minOperationsMaxProfit(new int[]{8,3,0,0},5,6));
    }

    @Test
    public void test3(){
        System.out.println(minOperationsMaxProfit(new int[]{5,0,0,0,0,30},5,5));
    }
}
