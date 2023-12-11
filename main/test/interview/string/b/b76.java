package interview.string.b;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class b76 {
    public String minWindow(String s, String t) {
        int n = s.length(),left =0,right = 0,minLeft = 0,minRight = n;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < t.length();i++){
            int temp = map.getOrDefault(t.charAt(i),0);
            map.put(t.charAt(i),temp+1);
        }

        for(int i = 0 ; i < n ;i++){
            char c = s.charAt(i);
            if(map.get(c)!=null){
                right=i;
                map.put(c,map.get(c)-1);
            }
            while(left<right&&(map.get(s.charAt(left))==null||map.get(s.charAt(left))<0)){
                if(map.get(s.charAt(left))!=null){
                    map.put(s.charAt(left),map.get(s.charAt(left))+1);
                }
                left++;
                if((right-left)<(minRight-minLeft)&&check(map)){
                    minLeft = left;
                    minRight = right;
                }
            }
        }
        if(!check(map))
            return "";

        return s.substring(minLeft,minRight+1);
    }
    public boolean check(Map<Character,Integer> map){
        for(int c:map.values())
            if(c>0)
                return false;
        return true;
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
}
