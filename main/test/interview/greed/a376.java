package interview.greed;

import org.junit.Test;

public class a376 {
    public int wiggleMaxLength(int[] nums) {
        int cur = Integer.MIN_VALUE,count = 0,maxCount = 0;
        for(int i = 1; i < nums.length;i++){
            nums[i-1] = nums[i]-nums[i-1];
            if(cur!=Integer.MIN_VALUE&&(cur|nums[i-1])<0){
                count++;
                maxCount=Math.max(count,maxCount);
            }
            cur = nums[i-1];
        }
        return maxCount==0?1:maxCount+2;
    }

    @Test
    public void test(){
        System.out.println(wiggleMaxLength(new int[]{1,7,4,9,2,5}));

    }
    @Test
    public void test1(){
        System.out.println(wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));

    }
    @Test
    public void test2(){
        System.out.println(wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));

    }
}
