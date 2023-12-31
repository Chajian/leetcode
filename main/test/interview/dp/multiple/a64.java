package interview.dp.multiple;

import org.junit.Test;
import tools.StringUtils;

public class a64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 1 ; i < m;i++)
            grid[i][0]+=grid[i-1][0];
        for(int i = 1 ; i < n ;i++)
            grid[0][i]+=grid[0][i-1];
        for(int i = 1;i<m;i++)
            for(int j = 1;j<n;j++)
                grid[i][j]=grid[i][j]+Math.min(grid[i][j-1],grid[i-1][j]);
        return grid[m-1][n-1];
    }

    @Test
    public void test(){
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        String a = StringUtils.middleBracketToLarge("[[1,2,3],[4,5,6]]");
        System.out.println(a);
        System.out.println(minPathSum(grid));
    }

    @Test
    public void test2(){
        int[][] grid = new int[][]{{1,2,3},{4,5,6}};
        System.out.println(minPathSum(grid));
    }
}
