package interview.dp.multiple;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class a120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int res = triangle.get(0).get(0);
        for(int i = 1 ; i < triangle.size();i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0 ;j < triangle.get(i).size();j++){
                int n;
                if(j==0){
                    n = triangle.get(i-1).get(0);
                }
                else if(j==triangle.get(i).size()-1)
                    n = triangle.get(i-1).get(triangle.get(i).size()-2);
                else {
                    n = (triangle.get(i - 1).get(j - 1) > triangle.get(i - 1).get(j) ? triangle.get(i - 1).get(j) : triangle.get(i - 1).get(j - 1));
                }
                n = triangle.get(i).get(j)+n;
                triangle.get(i).set(j,n);
                if(n<min)
                    min = n;
            }
            res = min;
        }

        return res;
    }

    @Test
    public void test(){
        List<List<Integer>> list = new ArrayList();
        List list1 = new ArrayList();
        list1.add(2);

        List list2 = new ArrayList();
        list2.add(3);
        list2.add(3);


        List list3 = new ArrayList();
        list3.add(6);
        list3.add(5);
        list3.add(7);

        List list4 = new ArrayList();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);


        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);

        System.out.println(minimumTotal(list));
    }


    @Test
    public void test2(){
        List<List<Integer>> list = new ArrayList();
        List list1 = new ArrayList();
        list1.add(-10);



        list.add(list1);


        System.out.println(minimumTotal(list));
    }
}
