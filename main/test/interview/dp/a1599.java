package interview.dp;

import org.junit.Test;

public class a1599 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int flat = 0,curcustomers = 0,increat = 0,n=customers.length,max=0;
        int dp[] = new int[n+1];
        for(int i = 0 ; i < customers.length;i++){
            curcustomers+=customers[i];
            increat+=customers[i];
            int temp = Math.min(4,curcustomers);
            curcustomers-=temp;
            System.out.println("当前轮次:"+flat+"剩余客人:"+curcustomers);
            dp[i+1]=dp[i]+temp*boardingCost-runningCost;
            if(dp[i+1]>max){
                max=dp[i+1];
                flat = i+1;
            }
        }
        int tempflat = curcustomers/4;
        int temp = curcustomers%4;
        int result = increat*boardingCost-(n+tempflat)*runningCost;
        if(result>max){
            flat = n+tempflat;
            max = result;
        }
        if(temp*boardingCost>runningCost)
            flat++;
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
