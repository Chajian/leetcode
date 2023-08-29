package interview.dp.again;

import org.junit.Test;

/**
 *
 * 未来等于现在+过去
 */
public class c70 {
    public int climbStairs(int n) {
        int last = 0,cur = 1,temp;
        for(int i = 0 ; i < n ;i++){
            temp = cur;
            cur = last + cur;
            last = temp;
        }
        return cur;
    }

    @Test
    public void test(){
        System.out.println(climbStairs(4));
    }
}
