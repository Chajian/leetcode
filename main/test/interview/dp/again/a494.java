package interview.dp.again;

import org.junit.Test;

public class a494 {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums,target,0,0);
    }

    public int dfs(int[] nums,int target,int i,int sum){
        if(i==nums.length){
            if(sum == target)
                return 1;
            return 0;
        }
        sum+=nums[i];//add
        int pos = dfs(nums,target,i+1,sum);
        sum-=nums[i];//reback
        sum-=nums[i];//reduce
        int reduce = dfs(nums,target,i+1,sum);
        return pos+reduce;
    }
    @Test
    public void test(){
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1},3));
        System.out.println(findTargetSumWays(new int[]{1},1));
    }
}
