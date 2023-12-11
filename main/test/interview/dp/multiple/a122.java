package interview.dp.multiple;

import org.junit.Test;

import java.lang.ref.Reference;
import java.util.ArrayList;

public class a122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        for(int i = 1 ; i < n;i++){
            int temp = prices[i]-prices[i-1];
            profit+=temp>0?temp:0;
        }
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
