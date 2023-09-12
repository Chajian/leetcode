package interview.dp.again;

import org.junit.Test;

public class a494 {
    int[] memory;
    public int findTargetSumWays(int[] nums, int target) {
        memory = new int[nums.length];
        return dfs(nums,target,0,0);
    }

    public int dfs(int[] nums,int target,int i,int sum){
        if(i==nums.length){
            if(sum == target)
                return 1;
            return 0;
        }
        int pos = dfs(nums,target,i+1,sum+nums[i]);//add
        int reduce = dfs(nums,target,i+1,sum-nums[i]);//reduce
        memory[i] = pos+reduce;
        System.out.print("["+i+"]："+memory[i]+"  ");
        return memory[i];
    }
    @Test
    public void test(){
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1},3));
//        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1,1},3));
    }
}
