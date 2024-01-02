package interview.string.b;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class b76 {
    public String minWindow(String s, String t) {
        int n = s.length(),left =0,right = 0,minLeft = 0,minRight = n,needLen = t.length();
        boolean status = true;
        //自定义哈希
        int[] map = new int[128];
        for(int i = 0 ; i < t.length();i++)
            map[t.charAt(i)]+=1;
        //哈希初始化
        for(int i = 0 ; i < map.length;i++)
            if(map[i]==0)
                map[i]=Integer.MIN_VALUE;

        //双指针left,right模拟滑动窗口，status状态决定，移动那个指针
        while(left <n&&right<=n){
            if(status){
                if(right>=n)
                    break;
                char c = s.charAt(right++);
                if(map[c]>Integer.MIN_VALUE){
                    map[c]--;
                    if(needLen>0&&map[c]>=0)
                        needLen--;
                    if(needLen==0) {
                        status = false;
                        if((right-left)<=(minRight-minLeft)){//记录最小的滑动窗口
                            minRight = right;
                            minLeft = left;
                        }
                    }
                }
            }
            if(!status){
                char c = s.charAt(left++);
                int temp = map[c];
                if(temp==0){
                    left--;//撤回操作
                    status=true;
                    if((right-left)<(minRight-minLeft)){//记录最小的滑动窗口
                        minRight = right;
                        minLeft = left;
                    }
                    if(right>=n)
                        break;
                }
                else if(temp<0&&temp != Integer.MIN_VALUE)
                    map[c]++;
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

