package interview.dp;

import org.junit.Test;

import java.util.Arrays;

public class a494 {
    int count = 0;
    int max;
    public int findTargetSumWays(int[] nums, int target) {
        Arrays.sort(nums);
        for(int num:nums)
            max+=num;
        add(nums,0,target,0);
        return count;
    }
    public int add(int[] nums,int i, int target,int current){
        if(i>=nums.length){
            if(current == target)
                count++;
            return current;
        }
        int add = add(nums,i+1,target,current+nums[i]);
        int reduce = add(nums,i+1,target,current-nums[i]);
        if(Math.abs(target-add)<=Math.abs(target-reduce))
            return add;
        return reduce;
    }
    @Test
    public void test(){
        System.out.println(findTargetSumWays(new int[]{1,0},1));
    }
}
