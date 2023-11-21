package interview.dp.multiple;

import org.junit.Test;

public class a72 {

    public int minDistance(String word1, String word2) {
        int n = word1.length()+1,m=word2.length()+1;
        int[][] dp = new int[n][m];
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        dp[0][0]=0;
        for(int j = 0 ; j < m;j++){
            dp[0][j] = j;
        }
        for(int i = 1 ; i < n ;i++){
            dp[i][0]=i;
            for(int j = 1 ; j < m ;j++){
                if(chars1[i-1]==chars2[j-1]){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        return dp[n-1][m-1];
    }

    @Test
    public void test(){
        System.out.println(minDistance("horse","ros"));
    }

    @Test
    public void test1(){
        System.out.println(minDistance("",""));
    }

    @Test
    public void test2(){
        System.out.println(minDistance("","123"));
    }
}
