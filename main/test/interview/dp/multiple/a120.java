package interview.dp.multiple;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 自顶向下dp
 */
public class a120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        for(int i = 1 ; i < len;i++){
            triangle.get(i).set(0,triangle.get(i-1).get(0)+triangle.get(i).get(0));
            int size = triangle.get(i).size();
            for(int j = 1 ;j < size-1;j++){
                triangle.get(i).set(j,triangle.get(i).get(j)+Math.min(triangle.get(i - 1).get(j - 1),triangle.get(i - 1).get(j)));
            }
            triangle.get(i).set(size-1,triangle.get(i-1).get(size-2)+triangle.get(i).get(size-1));
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < triangle.get(len-1).size();i++){
            min = Math.min(min,triangle.get(len-1).get(i));
        }
        return min;
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

    @Test
    public void test3(){
        int a = Integer.MAX_VALUE;
        System.out.println(a+1);
    }
}
