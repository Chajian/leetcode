package interview.dp.multiple;

import org.junit.Test;

public class b5 {
    boolean[][] dp;
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        dp = new boolean[s.length()][s.length()];
        int left=0,right=0;
        for(int i = 0; i < s.length() ;i++){
            for(int j = 0;j < i ;j++){
                if(chars[i]!=chars[j]||!isPalindrome(chars,j,i))
                    continue;
                dp[j][i] = true;
                if((i-j)>(right-left)) {
                    left = j;
                    right = i;
                }
                break;
            }
        }
        return s.substring(left,right+1);
    }

    /**
     * 判断是不是回文字
     * @param chars
     * @param left
     * @param right
     * @return
     */
    public boolean isPalindrome(char[] chars,int left,int right){
        if(left==right||dp[left][right])
            return true;
        if(chars[left]==chars[right]){
            if(right-left==1)
                return true;
            else
                return isPalindrome(chars,++left,--right);
        }
        return false;
    }

    @Test
    public void test(){
        System.out.println(longestPalindrome("cbbd"));
    }

    @Test
    public void test2(){
        System.out.println(longestPalindrome("babad"));
    }

    @Test
    public void test3(){
        System.out.println(longestPalindrome("a"));
    }

    @Test
    public void test4(){
        System.out.println(longestPalindrome("aa"));
    }

    @Test
    public void test5(){
        System.out.println(longestPalindrome("ab"));
    }

    @Test
    public void test6(){
        System.out.println(longestPalindrome("ccc"));
    }
}
