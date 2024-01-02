package week.double120;

import org.junit.Test;

//leetcode 2972  count-the-number-of-incremovable-subarrays-ii
public class a100167 {
    public long incremovableSubarrayCount(int[] nums) {
        int i = 0,n = nums.length;
        for(;i <n-1 ;i++){
            if(nums[i]>=nums[i+1])
                break;
        }
        if(i==n-1)
            return (1+n)*n/2;
        long ans = i+2;
        for(int j = n-1;j==n-1||nums[j]<nums[j+1];j--){
            while(i>=0&&nums[i]>=nums[j])
                i--;
            ans+=i+2;
        }

        return ans;
    }

    @Test
    public void test(){
        System.out.println(incremovableSubarrayCount(new int[]{1,2,3,4}));
    }

    @Test
    public void test1(){
        System.out.println(incremovableSubarrayCount(new int[]{6,5,7,8}));
    }

    @Test
    public void test2(){
        System.out.println(incremovableSubarrayCount(new int[]{8,7,6,6}));
    }
}
