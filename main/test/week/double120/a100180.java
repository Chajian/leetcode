package week.double120;

import org.junit.Test;

public class a100180 {
    public long largestPerimeter(int[] nums) {
        return getZhouchang(nums,0,0,0,0,0);
    }

    public int getZhouchang(int[] nums ,int count,int time,int max ,int pre,int i){
        if(i==nums.length){
            if(time<3)
                return -1;
            if((count-pre)<=pre)
                return -1;
            return count;
        }

        else if(i==nums.length&&(count-max)<max){
            return -1;
        }

        if(nums[i]<pre){
            return getZhouchang(nums,count,time,max,pre,i+1);
        }

        int chooseCur = getZhouchang(nums,count+nums[i],time+1,Math.max(nums[i],max),nums[i],i+1);
        int noChooseCur = getZhouchang(nums,count,time,max,pre,i+1);
        chooseCur = Math.max(chooseCur,noChooseCur);
        return chooseCur;
    }

    @Test
    public void test(){
        System.out.println(largestPerimeter(new int[]{5,5,5}));
    }

    @Test
    public void test2(){
        System.out.println(largestPerimeter(new int[]{1,12,1,2,5,50,3}));
    }

    @Test
    public void test3(){
        System.out.println(largestPerimeter(new int[]{5,5,50}));
    }
}
