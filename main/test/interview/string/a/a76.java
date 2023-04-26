package interview.string.a;

import org.junit.Test;

public class a76 {

    int[] tempMap,map;
    public String minWindow(String s, String t) {
        map = new int[128];
        char[] chars = s.toCharArray();
        for(char c:t.toCharArray()){
            map[c] +=1;
        }
        int i = 0,j=0,resultLeft = -1,resultRight = 999999;
        tempMap = new int[map.length];
        boolean flag = false;
        while(flag||j<s.length()){
            if(flag){
                if((j-i)<(resultRight-resultLeft)) {
                    resultLeft = i;
                    resultRight = j;
                }
                char cc = chars[i++];
                tempMap[cc]-=1;
                if(map[cc]>tempMap[cc])
                    flag = false;
            }
            else if(j<s.length()){
                    char c = chars[j++];
                    tempMap[c] += 1;
                    if(map[c]!=0&&compare()) {
                        flag = true;
                    }
            }
        }
        resultLeft = resultLeft==-1?0:resultLeft;
        resultRight = resultRight==999999?0:resultRight;
        return s.substring(resultLeft,resultRight);
    }

    public boolean compare(){
        for(byte i = 0 ; i < tempMap.length ;i++){
            if(map[i]>tempMap[i])
                return false;
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(minWindow("aasdfzxcvAZAZ","AzZa"));
//        System.out.println('z'-'A');
    }


}
