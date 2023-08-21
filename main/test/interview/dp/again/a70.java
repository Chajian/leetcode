package interview.dp.again;

import org.junit.Test;

/**
 * 递归实现
 */
public class a70 {
    public int climbStairs(int n){
        if(n<3)return n;
        return climbStairs(n-1)+climbStairs(n-2);
    }

    @Test
    public void test(){
        System.out.println(climbStairs(7));
    }
}
