package interview.greed;

import org.junit.Test;

public class b55 {
    public boolean canJump(int[] nums) {
        int i = 1;
        for(; i < nums.length&&0!=nums[i-1] ;i++)
            nums[i] = Math.max(nums[i],nums[i-1]-1);
        return i==nums.length;
    }

    @Test
    public void test(){
        System.out.println(canJump(new int[]{2,3,1,1,4}));
    }

    @Test
    public void test2(){
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }

    @Test
    public void test3(){
        System.out.println(canJump(new int[]{0}));
    }

    @Test
    public void test4(){
        System.out.println(canJump(new int[]{0,1}));
    }

    @Test
    public void test5(){
        System.out.println(canJump(new int[]{1,2}));
    }
}
