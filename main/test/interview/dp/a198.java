package interview.dp;

import org.junit.Test;

public class a198 {
    public int rob(int[] nums) {
        for(short i = 1 ; i < nums.length ;i++){
            if(i-2>=0)
                nums[i] += nums[i-2];
            if(nums[i]<nums[i-1]){
                nums[i] = nums[i-1];
            }
        }
        return nums[nums.length-1];
    }

    @Test
    public void test(){
        System.out.println(rob(new int[]{2,1,1,2}));
    }
}
