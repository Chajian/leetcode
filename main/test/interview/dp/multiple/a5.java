package interview.dp.multiple;

import org.junit.Test;

public class a5 {
    public String longestPalindrome(String s) {
        int start=0,end=0;
        if(s.length()==1)
            return s;
        for(int i = 0 ; i < s.length()-1;i++){
            //find core
            int left = i,right = i+1;
            while(left>=0&&s.charAt(left)==s.charAt(i))
                left--;
            while(right<s.length()&&s.charAt(right)==s.charAt(i))
                right++;

            while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)) {
                left--;
                right++;
            }
            left++;
            if((right-left)>(end-start)){
                start=left;
                end=right;
            }
        }
        return s.substring(start,end);
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
