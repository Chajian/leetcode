package tools;

import entity.Node;
import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Binary {

    /**
     * 层次遍历
     * @param nums
     * @return
     */
    List<TreeNode> linkedList = new ArrayList<>();
    public TreeNode ganerateTreeByLevel(Integer... nums){
        linkedList.add(new TreeNode(nums[0]));
        for(int i = 1 ; i < nums.length;i++){
            TreeNode node = null;
            if(nums[i]!=null){
                node = new TreeNode(nums[i]);
                int root = i%2==1?i/2:i/2-1;
                if(i%2==0){
                    linkedList.get(root).setRight(node);
                }
                else
                    linkedList.get(root).setLeft(node);
            }
            linkedList.add(node);
        }
        return linkedList.get(0);
    }

    /**
     * 层次遍历
     * @param nums
     * @return
     */
    List<Node> nodesList = new ArrayList<>();
    public Node ganerateNodeByLevel(Integer... nums){
        nodesList.add(new Node(nums[0]));
        for(int i = 1 ; i < nums.length;i++){
            Node node = null;
            if(nums[i]!=null){
                node = new Node(nums[i]);
                int root = i%2==1?i/2:i/2-1;
                if(i%2==1){
                    nodesList.get(root).left=node;
                }
                else
                    nodesList.get(root).right=node;
            }
            nodesList.add(node);
        }
        return nodesList.get(0);
    }



}
