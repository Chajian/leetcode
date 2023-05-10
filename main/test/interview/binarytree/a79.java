package interview.binarytree;

import org.junit.Test;
import tools.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class a79 {
    char[][] paths;
    public boolean exist(char[][] board, String word) {
        List<List<Integer>> lists = new ArrayList<>();
        char startc = word.charAt(0);
        paths = new char[board.length][board[0].length];
        for(int i = 0 ; i < board.length ;i++){
            for(int j = 0;j<board[i].length;j++){
                if(board[i][j]==startc&&move(board,word,i,j))
                    return true;
            }
        }
        return false;
    }
    public boolean move(char[][]board,String word,int i,int j){
        if(word.length()<=0)
            return true;
        if(i<0||i>=board.length||j<0||j>=board[i].length||paths[i][j]==1)
            return false;
        if(board[i][j] == word.charAt(0)) {
            paths[i][j]=1;
            String newWord = word.substring(1, word.length());
            if(move(board, newWord, i , j + 1))return true;
            if(move(board,newWord,i,j-1))return true;
            if(move(board,newWord,i+1,j))return true;
            if(move(board,newWord,i-1,j))return true;
        }
        paths[i][j]=0;
        return false;
    }

    @Test
    public void test(){

        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}
                }
                ,"ABCESEEEFS"));
    }

    @Test
    public void changeString(){
        String s = StringUtils.middleBracketToLarge("[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"E\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]");
        s = StringUtils.doubleDotToSingleDot(s);
        System.out.println(s);
    }
}
