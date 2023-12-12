package interview.string.b;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class b76 {
    public String minWindow(String s, String t) {
        int n = s.length(),left =0,right = 0,minLeft = 0,minRight = n,needLen = t.length();
        boolean status = true;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < t.length();i++)
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);

        while(left <n&&right<=n){
            if(status){
                if(right>=n)
                    break;
                char c = s.charAt(right++);
                if(map.getOrDefault(c,Integer.MIN_VALUE)>Integer.MIN_VALUE){
                    map.put(c,map.get(c)-1);
                    if(needLen>0&&map.get(c)>=0)
                        needLen--;
                    if(needLen==0) {
                        status = false;
                        if((right-left)<=(minRight-minLeft)){
                            minRight = right;
                            minLeft = left;
                        }
                    }
                }
            }
            if(!status){
                char c = s.charAt(left++);
                int temp = map.getOrDefault(c,Integer.MIN_VALUE);
                if(temp==0){
                    left--;//撤回操作
                    status=true;
                    if((right-left)<(minRight-minLeft)){
                        minRight = right;
                        minLeft = left;
                    }
                    if(right>=n)
                        break;
                }
                else if(temp<0&&temp != Integer.MIN_VALUE)
                    map.put(c,map.get(c)+1);
            }

        }
        if(needLen>0)
            return "";
        return s.substring(minLeft,minRight);
    }

    @Test
    public void test(){
        System.out.println(minWindow("a","aa"));
    }

    @Test
    public void test2(){
        System.out.println(minWindow("a","b"));
    }

    @Test
    public void test3(){
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }

    @Test
    public void test4(){
        System.out.println(minWindow("a","a"));
    }

    @Test
    public void test5(){
        System.out.println(minWindow("cabwefgewcwaefgcf","cae"));
    }

    @Test
    public void test6(){
        System.out.println(minWindow("ab","a"));
    }

    @Test
    public void test7(){
        System.out.println(minWindow("acbbaca","aba"));
    }

    @Test
    public void test8(){
        System.out.println(minWindow("aaaaaaaaaaaabbbbbcdd","abcdd"));
    }

    @Test
    public void test9(){
        System.out.println(minWindow("acbdbaab","aabd"));
    }
}

