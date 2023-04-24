package interview;

import org.junit.Test;

public class a76 {
    public String minWindow(String s, String t) {
        int[] map = new int[90];
        char[] chars = s.toCharArray();
        for(char c:t.toCharArray()){
            map[c-'A'] +=1;
        }
        int i = 0,j=0,resultLeft = -1,resultRight = 999999;
        int[] tempMap = new int[map.length];
        boolean flag = false;
        while(flag||j<s.length()){
            if(flag){
                if((j-i)<(resultRight-resultLeft)) {
                    resultLeft = i;
                    resultRight = j;
                }
                char cc = chars[i++];
                tempMap[cc-'A']-=1;
                if(map[cc-'A']>tempMap[cc-'A'])
                    flag = false;
            }
            else{
                if(j<s.length()){
                    char c = chars[j++];
                    tempMap[c - 'A'] += 1;
                    if(compare(map,tempMap)) {
                        flag = true;
                    }
                }
            }
        }
        resultLeft = resultLeft==-1?0:resultLeft;
        resultRight = resultRight==999999?0:resultRight;
        return s.substring(resultLeft,resultRight);
    }

    public boolean compare(int[] t,int[] s){
        for(int i = 0 ; i < s.length ;i++){
            if(t[i]>s[i])
                return false;
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(minWindow("aa","a"));
    }


}
