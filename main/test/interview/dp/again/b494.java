package interview.dp.again;

//记忆化搜索
public class b494 {
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
        sum+=nums[i];//add
        int pos = dfs(nums,target,i+1,sum);
        sum-=nums[i];//reback
        sum-=nums[i];//reduce
        int reduce = dfs(nums,target,i+1,sum);
        memory[i] = pos+reduce;
        return pos+reduce;
    }
}
