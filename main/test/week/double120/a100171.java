package week.double120;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

//question:2970
public class a100171 {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length,ans = 0,left = 1,right = n-2;
        for(int i = 1 ; i < n ;i++){
            if(nums[i]<=nums[i-1])
                break;
            left++;
        }
        for(int i = n-2 ; i > 0 ;i--){
            if(nums[i]>=nums[i+1])
                break;
            right--;
        }
        for(int i = 0 ; i < n;i++){
            for(int j = i;j<n;j++){
                if(i<=left&&j>=right&&(i==0||j==n-1||nums[j+1]>nums[i-1]))
                    ans++;
            }
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(incremovableSubarrayCount(new int[]{1,2,3,4}));
    }

    @Test
    public void test1(){
        System.out.println(incremovableSubarrayCount(new int[]{6,5,7,8}));
    }

    @Test
    public void test2(){
        System.out.println(incremovableSubarrayCount(new int[]{8,7,6,6}));
    }
}
