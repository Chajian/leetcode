package interview.dp;

public class a343 {
    public int integerBreak(int n) {
        if(n<=3) return n-1;
        int a = n/3;
        int b = n%3;
        switch (b){
            case 0:
                return (int) Math.pow(3,a);
            case 1:
                return 4*(int) Math.pow(3,a-1);
        }
        return 2*(int) Math.pow(3,a);
    }
}
