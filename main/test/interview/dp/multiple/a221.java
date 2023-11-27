package interview.dp.multiple;

import org.junit.Test;
import tools.StringUtils;

public class a221 {
    public int maximalSquare(char[][] matrix) {
        char max = '0';
        for(int i = 0 ; i <matrix[0].length&&max!='1';i++){
            if(matrix[0][i]=='1'){
                max='1';
            }
        }
        for(int i = 0 ; i <matrix.length&&max!='1';i++){
            if(matrix[i][0]=='1'){
                max='1';
            }
        }

        for(int i = 1 ; i < matrix.length;i++){
            for(int j = 1 ; j < matrix[i].length;j++){
                if(matrix[i][j]=='1'){
                    matrix[i][j] = (char) (Math.min(matrix[i-1][j],Math.min(matrix[i][j-1],matrix[i-1][j-1]))+1);
                    if(matrix[i][j]>max)
                        max = matrix[i][j];
                }
            }
        }
        max = max>'0'?max:'0';
        max -='0';
        return max*max;
    }

    @Test
    public void FormatString(){
        String info = "[[\"1\",\"1\",\"1\",\"1\",\"0\"],[\"1\",\"1\",\"1\",\"1\",\"0\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"0\",\"0\",\"1\",\"1\",\"1\"]]";
        info = StringUtils.middleBracketToLarge(info);
        info = StringUtils.doubleDotToSingleDot(info);
        System.out.println(info);
    }

    @Test
    public void test(){
        System.out.println(maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
    }

    @Test
    public void test2(){
        System.out.println(maximalSquare(new char[][]{{'0','1'},{'1','0'}}));
    }

    @Test
    public void test3(){
        System.out.println(maximalSquare(new char[][]{{'0'}}));
    }

    @Test
    public void test4(){
        System.out.println(maximalSquare(new char[][]{{'1'}}));
    }

    @Test
    public void test5(){
        System.out.println(maximalSquare(new char[][]{{'1','1','1','1','0'},{'1','1','1','1','0'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'0','0','1','1','1'}}));
    }
}
