package interview.dp.multiple;

import org.junit.Test;
import tools.StringUtils;

public class a63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        obstacleGrid[0][0]=obstacleGrid[0][0]==0?1:0;
        for(int i = 1 ; i < n;i++)
            obstacleGrid[0][i]=obstacleGrid[0][i]==0?obstacleGrid[0][i-1]:0;
        for(int i = 1 ; i < m;i++)
            obstacleGrid[i][0]=obstacleGrid[i][0]==0?obstacleGrid[i-1][0]:0;
        for(int i = 1;i<m;i++)
            for(int j = 1;j<n;j++)
                obstacleGrid[i][j] = obstacleGrid[i][j]==0?obstacleGrid[i-1][j]+obstacleGrid[i][j-1]:0;
        return obstacleGrid[m-1][n-1];
    }

    @Test
    public void tos(){
        String a = "[[0]]";
        System.out.println(StringUtils.middleBracketToLarge(a));
    }

    @Test
    public void test(){
        int[][] a = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(a));
    }

    @Test
    public void test2(){
        int[][] a = new int[][]{{0,1},{0,0}};
        System.out.println(uniquePathsWithObstacles(a));
    }

    @Test
    public void test3(){
        int[][] a = new int[][]{{0}};
        System.out.println(uniquePathsWithObstacles(a));
    }

    @Test
    public void test4(){
        int[][] a = new int[][]{{1,0}};
        System.out.println(uniquePathsWithObstacles(a));
    }

    @Test
    public void test5(){
        int[][] a = new int[][]{{1},{0}};
        System.out.println(uniquePathsWithObstacles(a));
    }
}
