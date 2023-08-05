package interview.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class a22 {
    List<String> result = new ArrayList<>();
    int step = 0;
    public List<String> generateParenthesis(int n) {
        step = n*2;
        backtracking(new StringBuilder(),0);
        return result;
    }


    public void backtracking(StringBuilder cur,int current){
        if(cur.length()==step&&current == 0){
            result.add(cur.toString());
            return;
        }
        if(current>step/2||current<0||cur.length()>step)
            return;
            cur.append('(');
            backtracking(cur,current+1);
            cur.deleteCharAt(cur.length()-1);
            cur.append(')');
            backtracking(cur,current-1);
            cur.deleteCharAt(cur.length()-1);
    }

    @Test
    public void test(){
        generateParenthesis(3);
        for(String s:result){
            System.out.println(s);
        }
    }


}
