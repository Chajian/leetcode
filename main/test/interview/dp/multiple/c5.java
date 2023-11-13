package interview.dp.multiple;

import org.junit.Test;

public class c5 {
    public String longestPalindrome(String s) {
        int len=0,start=0;
        char[] chars = s.toCharArray();
        for(int i = 0;i < s.length();i++){
            int len1 = getLen(chars,i,i);
            int len2 = getLen(chars,i,i+1);
            len1 = Math.max(len1,len2);
            if(len1>len){
                len = len1;
                start = i-(len-1)/2;
            }
        }
        return s.substring(start,start+len);
    }

    public int getLen(char[] chars,int l,int r){
        while(l>=0&&r<chars.length&&chars[l]==chars[r]){
            l--;
            r++;
        }
        return r-l-1;
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
