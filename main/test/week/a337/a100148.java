package week.a337;

import org.junit.Test;

import java.util.Arrays;

public class a100148 {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length ;i+=2){
            int temp = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = temp;
        }
        return nums;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(numberGame(new int[]{5,4,2,3})));
    }

    @Test
    public void test1(){
        System.out.println(Arrays.toString(numberGame(new int[]{2,5})));
    }
}
