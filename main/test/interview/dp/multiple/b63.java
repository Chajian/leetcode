package interview.dp.multiple;

import org.junit.Test;
import tools.StringUtils;

import java.util.Arrays;

public class b63 {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        dp = new int[m][n];
        for(int i = 0 ; i < m ;i++){
            Arrays.fill(dp[i],-1);
        }
        return pathSize(0,0,m,n,obstacleGrid);
    }

    public int pathSize(int i,int j,int m,int n,int[][]obstacleGrid){
        if(i>=m||j>=n||obstacleGrid[i][j]==1)
            return 0;
        if(i==m-1&&j==n-1)
            return 1;
        if(dp[i][j]>-1)
            return dp[i][j];
        dp[i][j] = pathSize(i+1,j,m,n,obstacleGrid)+pathSize(i,j+1,m,n,obstacleGrid);
        return dp[i][j];
    }

    @Test
    public void toS(){
        String a = "[[0,0,0],[0,1,0],[0,0,0]]";
        System.out.println(StringUtils.middleBracketToLarge(a));
    }

    @Test
    public void test(){
        int[][] a = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(a));
    }
}
