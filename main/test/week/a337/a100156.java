package week.a337;

import org.junit.Test;
import tools.StringUtils;

import java.util.*;

public class a100156 {
//    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
//        List<Map<Character,Integer>> memory =new ArrayList<>();
//        int n = original.length;
//        for(int i = 0 ; i <n ;i++ ){
//            int x = original[i]-'a',y=changed[i]-'a',z=cost[i];
//            dp[x][y]=dp[x][y]==0?z:Math.min(dp[x][y],z);
//        }
//        n = source.length();
//        int minCost = 0;
//        for(int i = 0 ; i < n;i++){
//            int x = source.charAt(i)-'a',y=target.charAt(i)-'a';
//            if(x==y)
//                continue;
//            long z=minCost(dp,x,y,0,new HashSet<>());
//            if(z==Long.MAX_VALUE)
//                return -1;
//            minCost+=z;
//        }
//        return minCost;
//    }
//
//    public long minCost(int[][] dp, int start, int target, int excost, Set<String> set){
//            long min = dp[start][target]!=0?dp[start][target]+excost:Long.MAX_VALUE;
//            for(int i = 0 ; i < dp.length;i++){
//                String reverTemp = i+"-"+start,temp = start+"-"+i;;
//                if(i!=start&&dp[i][target]!=0&&!set.contains(reverTemp)){
//
//                    set.add(temp);
//                    min = Math.min(min,minCost(dp,start,i,excost+dp[i][target],set));
//                    set.remove(temp);
//                }
//            }
//            return min;
//    }


    @Test
    public void test(){
//        long result = minimumCost("abcd","acbe",new char[]{'a','b','c','c','e','d'},new char[]{'b','c','b','e','b','e'},new int[]{2,5,5,1,2,20});
//        System.out.println(result);
    }
}
