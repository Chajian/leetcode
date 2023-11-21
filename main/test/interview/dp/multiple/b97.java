package interview.dp.multiple;

import org.junit.Test;

public class b97 {
    char[] c1,c2,c3;
    int[][] memory;
    int n,m,l;
    public boolean isInterleave(String s1, String s2, String s3) {
        n=s1.length();m=s2.length();l=s3.length();
        if(n+m!=l)
            return false;
        c1 = s1.toCharArray();c2=s2.toCharArray();c3=s3.toCharArray();
        memory = new int[n+1][m+1];
        return dfs(0,0);
    }

    public boolean dfs(int i,int j){
        if(i+j==l)
            return true;
        if(memory[i][j]!=0)
            return memory[i][j]==1;
        boolean ans = false;
        if(i<n&&c1[i]==c3[i+j]){
            ans |= dfs(i+1,j);
        }
        if(j<m&&c2[j]==c3[i+j]){
            ans |= dfs(i,j+1);
        }
        memory[i][j]=ans?1:-1;
        return ans;
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
