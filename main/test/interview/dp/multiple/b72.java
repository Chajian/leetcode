package interview.dp.multiple;

import org.junit.Test;

public class b72 {
    public int minDistance(String word1, String word2) {
        int n = word1.length()+1,m=word2.length()+1;
        n=n>2?2:n;
        int[][] dp = new int[n][m];
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        dp[0][0]=0;
        for(int j = 0 ; j < m;j++){
            dp[0][j] = j;
        }
        int l = word1.length()+1;
        for(int i = 1 ; i <l ;i++){
            dp[1][0]=i;
            for(int j = 1 ; j < m ;j++){
                if(chars1[i-1]==chars2[j-1]){
                    dp[1][j]=dp[0][j-1];
                }
                else{
                    dp[1][j]=Math.min(dp[0][j-1],Math.min(dp[0][j],dp[1][j-1]))+1;
                }
            }
            if(i!=l-1) {
                int[] temp = dp[0];
                dp[0] = dp[1];
                dp[1] = temp;
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

    @Test
    public void test3(){
        System.out.println(minDistance("intention","execution"));
    }
}
