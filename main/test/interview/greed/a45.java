package interview.greed;

import org.junit.Test;

public class a45 {
    public int jump(int[] nums) {
        if(nums.length<=1)
            return 0;
        int pointI = 0,pointJ=1,valI = nums[pointI],valJ=nums[pointJ],time = 1;
        for(int i = 1 ; i < nums.length ;i++){
            if((i-pointI)-nums[pointI]>0){
                pointI = pointJ;
                time++;
            }
            valJ--;
            if(nums[i]>valJ){
                pointJ = i;
                valJ = nums[i];
            }
        }
        return time;
    }

    @Test
    public void test(){
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }


    @Test
    public void test3(){
        System.out.println(jump(new int[]{0}));
    }

    @Test
    public void test4(){
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }

    @Test
    public void test5(){
        System.out.println(jump(new int[]{1,2}));
    }

    @Test
    public void test6(){
        System.out.println(jump(new int[]{2,1}));
    }

    @Test
    public void test7(){
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }

    @Test
    public void test8(){
        System.out.println(jump(new int[]{1,1,1,1}));
    }

    @Test
    public void test9(){
        System.out.println(jump(new int[]{1,2,3}));
    }
}
