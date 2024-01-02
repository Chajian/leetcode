package interview.greed;

import org.junit.Test;

import java.util.Arrays;

public class a455 {

    public int findContentChildren(int[] g, int[] s) {
        int n = g.length,m=s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for(int j = 0 ;j < m;j++)
            if(i<n&&s[j]>=g[i])
                i++;
            else if(i==n)
                break;
        return i;
    }

    public void quickSort(int[] g,int i,int j){
        if(i>=j)
            return;
        int left = i,right = j,midle = g[left];
        while(left<right){
            while(left<right&&g[right]>midle){
                right--;
            }
            g[left]=g[right];
            while(left<right&&g[left]<=midle){
                left++;
            }
            g[right]=g[left];
        }
        g[left]=midle;
        quickSort(g,i,left-1);
        quickSort(g,left+1,j);
    }

    @Test
    public void test(){
        System.out.println(findContentChildren(new int[]{1,2,3},new int[]{1,1}));
    }

    @Test
    public void test1(){
        System.out.println(findContentChildren(new int[]{1,2},new int[]{1,2,3}));
    }

    @Test
    public void quickSort(){
        int[] a = new int[]{12,34,21,412,34,1234,0,456,4,645,6,4564,2,123};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));

    }
}
