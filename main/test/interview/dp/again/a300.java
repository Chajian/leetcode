package interview.dp.again;

import org.junit.Test;

public class a300 {
    int res = Integer.MIN_VALUE;
    public int lengthOfLIS(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length;i++){
            max = Math.max(max,move(nums,i,1));
        }
        return max;
    }

    public int move(int[]nums ,int i,int time){
        if(i>=nums.length)
            return time;

        int max = Integer.MIN_VALUE;
        for(int j = i+1; j < nums.length ;j++){
            if(nums[j]<=nums[i])
                continue;
            max = Math.max(max,move(nums,j,time+1));
        }
        res = Math.max(time,max);
        return res;
    }

    @Test
    public void test(){
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
        System.out.println(lengthOfLIS(new int[]{1}));
//        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
