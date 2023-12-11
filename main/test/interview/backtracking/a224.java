package interview.backtracking;

import org.junit.Test;

public class a224 {
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        return dfs(chars,0);
    }

    public int dfs(char[] chars,int on){
        int temp = 0,temp2 =0;
        char option = ' ';
        while(on<chars.length){
            if(chars[on]=='(') {
                return option=='-'?reduce(temp,dfs(chars,on+1)):add(temp,dfs(chars,on+1));
            }
            if(temp==0&&chars[on]>'0'&&chars[on]<'9'){
                temp = option=='-'?'0'-chars[on]:chars[on]-'0';
            }
            else if(chars[on]>='0'&&chars[on]<='9'){
                if(option=='+') {
                    temp = add(temp, chars[on] - '0');
                    option = ' ';
                }
                else if(option=='-') {
                    temp = reduce(temp, chars[on] - '0');
                    option = ' ';
                }
                else {
                    temp *= 10;
                    temp = add(temp, chars[on] - '0');
                }
            }
            else if(chars[on]=='-'||chars[on]=='+'){
                option = chars[on];
            }
            on++;
        }
        return temp;
    }

    public int add(int a,int b){
        return a+b;
    }

    public int reduce(int a,int b){
        return a-b;
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
}
