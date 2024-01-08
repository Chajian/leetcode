package interview.graph;

import com.ctc.wstx.util.StringUtil;
import org.junit.Test;
import tools.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a797 {
    List<List<Integer>> list;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.get(0).add(0);
        dfs(graph,0,list.get(0));
        return list;
    }

    public void dfs(int[][] graph,int i,List<Integer> cur){
        if(graph[i].length==0)
            return;

        for(int k = 1 ; k < graph[i].length;k++){
            int on = graph[i][k];
            List<Integer> next = new ArrayList();
            next.addAll(cur);
            next.add(on);
            if(on!=graph.length-1)
                dfs(graph,on,next);
            if(next.get(next.size()-1)==graph.length-1)
                list.add(next);

        }
        cur.add(graph[i][0]);
        if(graph[i][0]!=graph.length-1)
            dfs(graph,graph[i][0],cur);
    }
    @Test
    public void string(){
        System.out.println(StringUtils.middleBracketToLarge("[[2],[],[1]]"));
    }

    @Test
    public void test2(){
        int[][] aa = new int[][]{{4,3,1},{3,2,4},{},{4},{}};
        System.out.println(Arrays.toString(allPathsSourceTarget(aa).toArray()));
    }

    @Test
    public void test3(){
        int[][] aa = new int[][]{{2},{},{1}};
        System.out.println(Arrays.toString(allPathsSourceTarget(aa).toArray()));
    }
}
