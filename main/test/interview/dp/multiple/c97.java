package interview.dp.multiple;

import org.junit.Test;

public class c97 {

    public boolean isInterleave(String s1, String s2, String s3) {
        int n=s1.length(),m=s2.length(),l=s3.length();
        if(n+m!=l)
            return false;
        char[] c1 = s1.toCharArray(),c2=s2.toCharArray(),c3=s3.toCharArray();
        int[][]dp = new int[n+1][m+1];
        dp[0][0]=1;
        for(int i = 1 ; i <= n && dp[i-1][0]==1;i++)
            if(c1[i-1]==c3[i-1])dp[i][0]=1;
        for(int i = 1 ; i <= m && dp[0][i-1]==1;i++)
            if(c2[i-1]==c3[i-1])dp[0][i]=1;
        for(int i = 1 ;i <=n;i++){
            for(int j = 1 ; j <= m;j++){
                if(c2[j-1]==c3[i+j-1]&& dp[i][j-1]==1)
                    dp[i][j]=1;
                if(c1[i-1]==c3[i+j-1]&& dp[i-1][j]==1)
                    dp[i][j]=1;
            }
        }
        return dp[n][m]==1;
    }

    @Test
    public void test1(){
        System.out.println(isInterleave("aabcc","dbbca","aadbbcbcca"));
    }


    @Test
    public void test2(){
        System.out.println(isInterleave("aabcc","dbbca","aadbbcbcac"));
    }

    @Test
    public void test3(){
        System.out.println(isInterleave("aabcc","dbbca","aadbbcbccc"));
    }

    @Test
    public void test5(){
        System.out.println(isInterleave("aabc","abad","aabcabad"));
    }
}
