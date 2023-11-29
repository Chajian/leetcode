package interview.dp.multiple;

import org.junit.Test;

public class b122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0,pre = 0,cur=1;
        while(cur<n){
            if(prices[cur]<prices[cur-1]) {
                profit += prices[cur - 1] - prices[pre];
                pre = cur;
            }
            cur++;
        }
        int temp = prices[cur - 1] - prices[pre];
        profit+=temp>0?temp:0;
        return profit;
    }
    @Test
    public void test(){
        int[] info = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(info));
    }

    @Test
    public void test2(){
        int[] info = new int[]{2,1,2,0,1};
        System.out.println(maxProfit(info));
    }
}
