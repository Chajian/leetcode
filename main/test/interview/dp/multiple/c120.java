package interview.dp.multiple;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
自底向上
 */
public class c120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = triangle.size()-2;i>=0;i--)
            for(int j = 0 ; j < triangle.get(i).size();j++)
                triangle.get(i).set(j,triangle.get(i).get(j)+Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
        return triangle.get(0).get(0);
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
