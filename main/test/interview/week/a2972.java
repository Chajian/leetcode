package interview.week;

import org.junit.Test;

public class a2972 {
    public long incremovableSubarrayCount(int[] nums) {
        int n = nums.length,left = 0,right=n-1;
        for(int i = 1 ; i < n;i++){
            if(nums[i]<=nums[i-1])
                break;
            left++;
        }
        left++;
        return (1+left)*left/2;
//        if(left==n-1)
//            return (1+n)*n/2;
        for(int i = n-2;i >=0;i--){
            if(nums[i]>=nums[i+1])
                break;
            right--;
        }
//        long ans = left+1*n-right-1;
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
    public void test1(){
        System.out.println(incremovableSubarrayCount(new int[]{8,7,6,6}));
    }
}
