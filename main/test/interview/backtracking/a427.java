package interview.backtracking;

import org.junit.Test;

public class a427 {

    public Node construct(int[][] grid) {
        return separate(grid,0,grid.length-1,0,grid.length-1);
    }

    public Node separate(int[][] grid,int startI,int endI,int startJ,int endJ){
        if(startI == endI && startJ == endJ)
            return new Node(grid[startJ][startI]==1,true);
        int middleI = startI+(endI-startI)/2,middleJ = startJ+(endJ-startJ)/2;
        Node node = new Node(true,false,separate(grid,startI,middleI,startJ,middleJ),separate(grid,middleI+1,endI,startJ,middleJ),separate(grid,startI,middleI,middleJ+1,endJ),separate(grid,middleI+1,endI,middleJ+1,endJ));
        if(node.topLeft.isLeaf&node.topRight.isLeaf&node.bottomLeft.isLeaf&node.bottomRight.isLeaf) {
            if ((!node.topLeft.val ^ node.topRight.val)&(!node.bottomLeft.val ^ node.bottomRight.val)&(!node.topRight.val^node.bottomRight.val)) {
                return new Node(node.topLeft.val, true);
            }
        }
        return node;
    }
@Test
    public void test(){
        Node node = construct(new int[][]{{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}});
    }

    @Test
    public void test2(){
    }


    // Definition for a QuadTree node.
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }


    // Definition for a QuadTree node.

}
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
