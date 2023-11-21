package interview.dp.again;


import org.junit.Test;

public class a494 {
    int[] memory;
    public int findTargetSumWays(int[] nums, int target) {

        memory = new int[nums.length];
        StringBuilder stringBuilder = new StringBuilder();
        return dfs(stringBuilder,nums,target,0,0);
    }

    public int dfs(StringBuilder path,int[] nums,int target,int i,int sum){
        if(i==nums.length){
            System.out.print(path.toString()+"："+memory[i-1]+"\t");
            if(sum == target)
                return 1;
            return 0;
        }


        path.append(i);
//        System.out.print(path.toString()+"："+memory[i]+"\t");
        int pos = dfs(path,nums,target,i+1,sum+nums[i]);//add
        path.deleteCharAt(path.length()-1);

        path.append("-"+i);
//        System.out.print(path.toString()+"："+"\t");
        int reduce = dfs(path,nums,target,i+1,sum-nums[i]);//reduce
        path.deleteCharAt(path.length()-1);
        path.deleteCharAt(path.length()-1);
        memory[i] = pos+reduce;
        return memory[i];
    }
    @Test
    public void test(){
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1},3));
//        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1,1},3));
    }
}
