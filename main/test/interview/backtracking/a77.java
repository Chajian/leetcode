package interview.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * 解题思路
 * 双指针，递归，回溯
 */
public class a77 {
    List<List<Integer>> results = new ArrayList<>();
    int n,k;
    public List<List<Integer>> combine(int n, int k) {
        this.n=n;this.k=k;
        backtracking2(1,new ArrayList(),k);
        return results;
    }

    /**
     * 可优化的点
     * 1. n和k常量不需要进行递归
     * 2. List.copyOf(num)可进行优化
     * 3. 可讲n和j条件分开
     * @param i
     * @param num
     * @param j
     * @param n
     * @param k
     */
    public void backtracking(int i,List<Integer> num,int j,int n,int k){
        if(i>n || j<=0) {
            if(j==0){
                results.addAll(Collections.singleton(num));
            }
            return;
        }
        num.add(i);//添加本次操作
        backtracking(i+1,num,j-1,n,k);
        num.remove(k-j);//撤回本次操作
        backtracking(i+1,num,j,n,k);
    }

    public void backtracking2(int i,List<Integer> num,int j){
        if(j==0){
            results.add(List.copyOf(num));
            return;
        }
        if(i>n||(n-i+1)<j)
            return;
        num.add(i);//添加本次操作
        backtracking2(i+1,num,j-1);
        num.remove(k-j);//撤回本次操作
        backtracking2(i+1,num,j);
    }

    @Test
    public void test(){
        combine(4,2);
        for(List<Integer> list:results){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
