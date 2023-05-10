package tools;


import java.util.ArrayList;
import java.util.List;

/**
 * generate Prime tool
 */
public class Prime {
    public static List primeZereToN(int n){
        List<Integer> primes = new ArrayList();
        while(n-->0){
            if(n%2!=0&&n%3!=0)
                primes.add(n);
        }
        return  primes;
    }

    public static List primes(int times){
        int count = 0;
        int n = 2;
        List list = new ArrayList();
        while(count<times){
            if(n%2!=0&&n%3!=0) {
                list.add(n);
                count++;
            }
            n++;
        }
        return list;
    }

    public static int charToInt(int[] nums,char a){
        return nums[a-'a'];
    }

    public static long StringtoLongByAdd(List<Integer> nums, String a){
        long l = 0;
        for(char c:a.toCharArray()){
            l+= (long)nums.get((c-'a'));
        }
        return l;
    }

    public static long StringtoLongByMultiply(List<Integer> nums, String a){
        long l = 1;
        for(char c:a.toCharArray()){
            l*= (long)nums.get((c-'a'));
        }
        return l;
    }

}
