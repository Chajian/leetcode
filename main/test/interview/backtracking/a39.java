package interview.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a39 {

    List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates,target,0,0,new ArrayList<>());
        return results;
    }

    public void backtracking(int [] candidates,int target,int current,int i,List<Integer> num){
        if(current==target){
            results.add(List.copyOf(num));
            return;
        }
        for(;i<candidates.length;i++){
            if(current+candidates[i]>target)
                return;
            current+=candidates[i];
            num.add(candidates[i]);
            backtracking(candidates,target,current,i,num);
            num.remove(num.size()-1);
            current-=candidates[i];
        }
    }

    @Test
    public void test(){
        combinationSum(new int[]{2,3,6,7},7);
        for(List<Integer> a:results){
            System.out.println(Arrays.toString(a.toArray()));
        }
    }

}
