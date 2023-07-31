package interview.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a17 {

    List<String> result = new ArrayList();
    Map<Character,String> map = new HashMap<>();
    String digits;
    public List<String> letterCombinations(String digits) {
        if(digits.equals(""))
            return result;
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        this.digits = digits;
        StringBuilder stringBuilder = new StringBuilder();
        backtracking(0,0,stringBuilder);
        return result;
    }

    public void backtracking(int i,int j,StringBuilder stringBuilder){
        if(stringBuilder.length()==digits.length()){
            result.add(stringBuilder.toString());
        }
        if(i>=digits.length())
            return;
        if(j>=map.get(digits.charAt(i)).length())
            return;
        for(char c:map.get(digits.charAt(i)).toCharArray()){
            stringBuilder.append(c);
            backtracking(i+1,j,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }

    @Test
    public void test(){
        letterCombinations("2");
        for(String s:result){
            System.out.println(s);
        }
    }

}
