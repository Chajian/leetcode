package week.double120;

import org.junit.Test;

import java.util.Arrays;

public class a100180 {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int max = 0;
        long[] dp = new long[n];
        dp[0]=nums[0];
        for(int i = 1;i<n;i++){
            if(nums[i]>=nums[i-1]&&dp[i-1]>nums[i]&&i>=2)
                max=i;
            dp[i]=dp[i-1]+nums[i];
        }
        return max>0?dp[max]:-1;
    }


    @Test
    public void test(){
        System.out.println(largestPerimeter(new int[]{5,5,5}));
    }

    @Test
    public void test2(){
        System.out.println(largestPerimeter(new int[]{1,12,1,2,5,50,3}));
    }

    @Test
    public void test3(){
        System.out.println(largestPerimeter(new int[]{5,5,50}));
    }

    @Test
    public void test4(){
        System.out.println(largestPerimeter(new int[]{300005055,352368231,311935527,315829776,327065463,388851949,319541150,397875604,311309167,391897750,366860048,359976490,325522439,390648914,359891976,369105322,350430086,398592583,354559219,372400239,344759294,379931363,308829137,335032174,336962933,380797651,378305476,336617902,393487098,301391791,394314232,387440261,316040738,388074503,396614889,331609633,374723367,380418460,349845809,318514711,308782485,308291996,375362898,397542455,397628325,392446446,368662132,378781533,372327607,378737987}));
    }
}
