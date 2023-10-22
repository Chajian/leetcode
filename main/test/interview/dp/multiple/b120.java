package interview.dp.multiple;

import java.util.List;

public class b120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null || triangle.size()==0) {
            return 0;
        }
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        //申请的dp数组为最长列+1
        int[] dp = new int[m+1];
        for(int i=n-1;i>=0;--i) {
            //从左到右的方式计算
            for(int j=0;j<triangle.get(i).size();++j) {
                dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
            }
        }
        //dp数组的第一个元素即为最终结果
        return dp[0];
    }
}
