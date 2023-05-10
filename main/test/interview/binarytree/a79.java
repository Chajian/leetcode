package interview.binarytree;

import org.junit.Test;
import tools.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class a79 {
    char[] key;
    int len;
    public boolean exist(char[][] board, String word) {
        char startc = word.charAt(0);
        key = word.toCharArray();
        len = word.length();
        for(int i = 0 ; i < board.length ;i++){
            for(int j = 0;j<board[i].length;j++){
                if(move(board,i,j,0))
                    return true;
            }
        }
        return false;
    }
    public boolean move(char[][]board,int i,int j,int index){
        if(index>=len)
            return true;
        if(i<0||i>=board.length||j<0||j>=board[i].length||board[i][j]!=key[index])
            return false;
        else {
            board[i][j]+=100;
            index++;
            if(move(board, i+1 , j,index))return true;
            if(move(board,i-1,j,index))return true;
            if(move(board,i,j+1,index))return true;
            if(move(board,i,j-1,index))return true;
            board[i][j]-=100;
            return false;
        }
    }

    @Test
    public void test(){

        System.out.println(exist(new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}}
                ,"AAB"));
    }

    @Test
    public void changeString(){
        String s = StringUtils.middleBracketToLarge("[[\"C\",\"A\",\"A\"],[\"A\",\"A\",\"A\"],[\"B\",\"C\",\"D\"]]");
        s = StringUtils.doubleDotToSingleDot(s);
        System.out.println(s);
    }
}
