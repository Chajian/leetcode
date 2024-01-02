package interview.greed;

import org.junit.Test;

public class a53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length, max = nums[0];
        for(int i = 1 ; i < n ;i++){
            nums[i] = Math.max(nums[i],nums[i-1]+nums[i]);
            if(nums[i]>max)
                max = nums[i];
        }
        return max;
    }

    @Test
    public void test(){
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    @Test
    public void test2(){
        System.out.println(maxSubArray(new int[]{1}));
    }

    @Test
    public void test3(){
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
    }
}
