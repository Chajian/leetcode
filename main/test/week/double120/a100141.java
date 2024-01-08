package week.double120;

import org.junit.Test;
import tools.StringUtils;

import java.util.*;
//2973
public class a100141 {
    long[] result;
    public long[] placedCoins(int[][] edges, int[] cost) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = edges.length,m = cost.length;
        result = new long[m];
        for(int i = 0 ; i <n ;i++){
            int left = edges[i][0];
            int right = edges[i][1];
            if(map.get(left)==null){
                map.put(left,new ArrayList<>());
            }
            map.get(left).add( (i+1));
        }
        Arrays.fill(result,1);
        dfs(edges,cost,map,0);
        return result;
    }

    public List<Integer> dfs(int[][] edges,int[]cost,Map<Integer,List<Integer>> map,int cur){
        if(map.get(cur)==null){
            return List.of(cost[cur]);
        }
        else if(map.get(cur).size()<2){
            List<Integer> list = map.get(cur);
            for(int i = 0 ; i < list.size();i++){
                list.set(i,cost[list.get(i)]);
            }
            return list;
        }
        else{
            List<Integer> list = map.get(cur);
            List<Integer> temp = new ArrayList<>();
            temp.add(cost[cur]);
            for(int i = 0 ; i < list.size();i++){
                temp.addAll(dfs(edges,cost,map,list.get(i)));
            }
            Collections.sort(temp);
            int len = temp.size();
            long max = Math.max((long)temp.get(0)*temp.get(1)*temp.get(len-1),(long)temp.get(len-1)*temp.get(len-2)*temp.get(len-3));
            result[cur]=Math.max(0,max);
            return temp;
        }
    }

    @Test
    public void string(){
        System.out.println(StringUtils.middleBracketToLarge("[[0,2],[0,6],[1,4],[3,5],[7,6],[3,6],[1,8],[3,1],[9,3]]"));
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(placedCoins(new int[][]{{0,1},{0,2},{0,3},{0,4},{0,5}},new int[]{1,2,3,4,5,6})));
    }

    @Test
    public void test1(){
        System.out.println(Arrays.toString(placedCoins(new int[][]{{0,1},{0,2},{0,3},{0,4},{0,5}},new int[]{1,2,3,4,5,6})));
    }

    @Test
    public void test2(){
        System.out.println(Arrays.toString(placedCoins(new int[][]{{0,2},{0,6},{1,4},{3,5},{7,6},{3,6},{1,8},{3,1},{9,3}},new int[]{63,13,-6,20,56,-14,61,25,-99,54})));
    }
}
