package interview.dp;

import org.junit.Test;

public class a70 {
    public int climbStairs(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) Math.round(fibn / sqrt5);
    }

    @Test
    public void test(){
        System.out.println(climbStairs(5));
    }
}
