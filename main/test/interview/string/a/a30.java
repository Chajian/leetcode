package interview.string.a;

import org.junit.Test;
import tools.Prime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class a30 {

    public List<Integer> findSubstring(String s, String[] words) {
        List list = new ArrayList();
        List<Integer> nums = primes(26);
        StringBuilder wordsBuilder = new StringBuilder();
        HashMap<String,Integer> map = new HashMap<>();
        for(String s1:words){
            map.put(s1,map.getOrDefault(s1,0)+1);
            wordsBuilder.append(s1);
        }
        long wordsNum = StringtoLongByAdd(nums,wordsBuilder.toString());
        int i = 0,t=i,left = i,j=0,wordlen = words[0].length(),wordslen = wordlen*words.length;
        HashMap<String,Integer> temp = new HashMap<>();
        long tempNums = 0;
        while(i<=s.length()-wordslen) {
            if((j-i) < wordslen)
                tempNums += nums.get(s.charAt(j++)-'a');
            else{
                if(tempNums==wordsNum){
                    for(t = i ; t < j ; t+=wordlen){
                        String st = s.substring(t,t+wordlen);
                        if(!map.containsKey(st)){
                            break;
                        }
                        temp.put(st,temp.getOrDefault(st,0)+1);
                    }
                    if(temp.equals(map)) {
                        list.add(i);
                        if(map.keySet().size()>1)
                            i+=wordlen-1;
                    }
                    temp.clear();
                }
                String st = s.substring(left,++i);
                tempNums-=StringtoLongByAdd(nums,st);
                left = i;
            }
        }
        return list;
    }

    public static List primes(int times){
        int count = 0;
        int n = 2;
        List list = new ArrayList();
        while(count<times){
            if(n%2!=0&&n%3!=0) {
                list.add(n);
                count++;
            }
            n++;
        }
        return list;
    }

    public static long StringtoLongByAdd(List<Integer> nums,String a){
        long l = 0;
        for(char c:a.toCharArray()){
            l+= (long)nums.get((c-'a'));
        }
        return l;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(findSubstring("abaababbaba",new String[]{"ab","ba","ab","ba"}).toArray()));
    }
}
