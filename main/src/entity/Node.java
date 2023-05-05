package entity;


/*
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
 */

public class Node {
    public int val;
    public Node left,right,next;
    public Node(int val){
        this.val = val;
    }
}
