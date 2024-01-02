package interview.dp.multiple;

import org.junit.Test;

public class a224 {
    int on = 0;
    public int calculate(String s) {
        int temp = 0,temp2=0;
        int sign = 1;
        while(on<s.length()){
            char c = s.charAt(on);
            on++;
            switch (c){
                case '(':
                    temp+=sign*calculate(s);
                    break;

                case ')':
                    temp+=sign*temp2;
                    temp2 = 0;
                    return temp;

                case ' ':
                    temp+=sign*temp2;
                    temp2 = 0;
                    break;

                case '-':
                    temp+=sign*temp2;
                    temp2 = 0;
                    sign=-1;
                    break;

                case '+':
                    temp+=sign*temp2;
                    temp2 = 0;
                    sign=1;
                    break;

                default:
                    temp2 *=10;
                    temp2 += c-'0';
                    break;
            }
        }
        if(temp2!=0){
            temp+=sign*temp2;
            temp2 = 0;
        }

        return temp;
    }

    @Test
    public void test(){
        System.out.println(calculate("1 + 1"));
    }

    @Test
    public void test2(){
        System.out.println(calculate("(1) - (1) + (7)"));
    }

    @Test
    public void test3(){
        System.out.println(calculate("((1 + 1) - (9- ( - 90 + 23)) - 5)"));
    }

    @Test
    public void test4(){
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }

}
