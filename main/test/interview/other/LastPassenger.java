package interview.other;

import org.junit.Test;

import java.util.Arrays;

/**
 * 最晚乘车
 */
public class LastPassenger {

    public int aa(int[] bus,int[] passengers,int capacity){
        int maxTime = 0;
        Arrays.sort(bus);Arrays.sort(passengers);
        //k车子下标，j乘客下标,i时间是否能坐上车
        int curCapacity = capacity;//当前车子的容量
        for(int i = 1,j=0,k=0 ; i < bus[bus.length-1]&&k<bus.length;i++){
            int btime = bus[k];
            if(j>=passengers.length)
                return bus[bus.length-1];
            int ptime = passengers[j];
            if(i<=btime) {//当前时间能否乘车?
                if (i == ptime) {//是否有其他乘客抢座?
                    if(--curCapacity==0){
                        k++;
                        curCapacity = capacity;
                    }
                    j++;
                } else {//没有抢座则当前时间可以抵达
                    maxTime = i;
                }
                if(i==btime) {//车子发动时，移动下标,重置车容量
                    k++;
                    curCapacity = capacity;
                }
            }
            else{//车子发动时，移动下标,重置车容量
                k++;
                curCapacity = capacity;
            }
        }
        return maxTime;
    }
    @Test
    public void test(){
        System.out.println(aa(new int[]{10,20},new int[]{2,17,18,19},2));
        System.out.println(aa(new int[]{10,20,30},new int[]{4,11,13,19,21,25,26},2));
        System.out.println(aa(new int[]{10,20,30},new int[]{30,40,50,60,70,80,90},3));
    }

}
