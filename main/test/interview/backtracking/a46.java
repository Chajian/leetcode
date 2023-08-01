package interview.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a46 {

    List<List<Integer>> results = new ArrayList<>();
    boolean[] ischoose;
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length<=0)
            return results;
        this.nums = nums;
        ischoose = new boolean[nums.length];
        backtracking(new ArrayList<Integer>(),0);
        return results;
    }

    public void backtracking(List<Integer> num,int depth){
        if(depth == nums.length){
            results.add(List.copyOf(num));
            return;
        }
        for(int i = 0 ; i < nums.length;i++){//bfs
            if(ischoose[i])
                continue;
            num.add(nums[i]);
            ischoose[i] = true;
            backtracking(num,depth+1);//dfs
            num.remove(num.size()-1);//revocation
            ischoose[i] = false;
        }
    }

    @Test
    public void test(){
        permute(new int[]{1,2,3});
        for(List<Integer> list:results){
            Arrays.toString(list.toArray());
        }
    }

}
