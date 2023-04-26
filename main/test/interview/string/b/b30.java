package interview.string.b;

import org.junit.Test;

import java.util.*;

public class b30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        //init map data
        for(String t:words)
            map.put(t,map.getOrDefault(t,0)+1);
        HashMap<String,Integer> tempmap = new HashMap<>();
        int wordlen = words[0].length(),wordslen = words.length*wordlen,j=0,i=0;
        for(int left =  0 ; left < wordlen ;left++){
            i = left;
            j = left;
            tempmap.clear();
            while(i<=s.length()-wordslen){
                String s1 = null;
                if(j-i<wordslen){
                    s1 = s.substring(j,j+wordlen);
                    j+= wordlen;
                }
                if(s1!=null){
                    if(map.containsKey(s1)){
                        tempmap.put(s1,tempmap.getOrDefault(s1,0)+1);
                        while(tempmap.get(s1)>map.get(s1)){
                            String t = s.substring(i,i+wordlen);
                            tempmap.put(t,tempmap.getOrDefault(t,0)-1);
                            i+=wordlen;
                        }
                        if(tempmap.equals(map)){
                            list.add(i);
                            String t = s.substring(i,i+wordlen);
                            tempmap.put(t,tempmap.getOrDefault(t,0)-1);
                            i+=wordlen;
                        }
                    }
                    else{
                        tempmap.clear();
                        i = j;
                    }
                }
                else{
                    tempmap.clear();
                    i = j;
                }
            }
        }
        return list;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","good"}).toArray()));
    }



}
