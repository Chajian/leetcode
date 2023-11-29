package interview.greed;

import org.junit.Test;

public class a55 {
    public boolean canJump(int[] nums) {
        int max = 1;
        for(int i = 0 ; i < nums.length ;i++){
            if(max==0)
                return false;
            max = nums[i]>=max?nums[i]:--max;
        }
        return true;
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
        System.out.println(canJump(new int[]{0,0}));
    }

    @Test
    public void test5(){
        System.out.println(canJump(new int[]{1,2}));
    }

    @Test
    public void test6(){
        System.out.println(canJump(new int[]{2,3,1,1,4}));
    }
}
