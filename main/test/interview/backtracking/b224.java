package interview.backtracking;

import org.junit.Test;

import java.util.Stack;

public class b224 {
    Stack<Integer> signs = new Stack<Integer>();
    Stack<Integer> nums = new Stack<Integer>();
    public int calculate(String s) {
        int temp=0,temp2=0,sign=1;
        for(int i = 0 ; i < s.length() ;i++){
            char c = s.charAt(i);
            switch (c){
                case '(':
                    signs.push(sign);
                    sign = 1;
                    temp+=sign*temp2;
                    nums.push(temp);
                    temp2=0;
                    temp=0;
                    break;

                case ')':
                    temp+=sign*temp2;
                    temp2=0;
                    temp = nums.pop()+signs.pop()*temp;
                    break;

                case '+':
                    temp+=sign*temp2;
                    temp2=0;
                    sign = 1;
                    break;

                case '-':
                    temp+=sign*temp2;
                    temp2=0;
                    sign = -1;
                    break;

                case ' ':
                    break;

                default:
                    temp2*=10;
                    temp2+=c-'0';
                    break;
            }

        }
        if(temp2 !=0)
            temp+=sign*temp2;
        return temp;
    }




    @Test
    public void test(){
        System.out.println(calculate("1 + 1"));
    }

    @Test
    public void test2(){
        System.out.println(calculate("1 - 1"));
    }

    @Test
    public void test3(){
        System.out.println(calculate("1 + 1 - 1+1"));
    }
    @Test
    public void test4(){
        System.out.println(calculate("1 + 1-(5+7)"));
    }

    @Test
    public void test5(){
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    @Test
    public void test6(){
        System.out.println(calculate("2147483647"));
    }

    @Test
    public void test7(){
        System.out.println(calculate("  30"));
    }

    @Test
    public void test8(){
        System.out.println(calculate("1-(     -2)"));
    }

    @Test
    public void test9(){
        System.out.println(calculate("123 + 166-127"));
    }

    @Test
    public void test10(){
        System.out.println(calculate("123 + 166"));
    }

    @Test
    public void test11(){
        System.out.println(calculate("(7)-(0)+(4)"));
    }

    @Test
    public void test12(){
        System.out.println(calculate("- (3 + (4 + 5))"));
    }
}
