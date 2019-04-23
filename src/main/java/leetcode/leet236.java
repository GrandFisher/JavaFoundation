package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xuan
 * @date 2019-04-07 15:19.
 */

public class leet236 {




    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       int pp=0;int qp=0;
       int cnt=0;
       Queue<TreeNode> queue=new LinkedList<>();
       queue.offer(root);
       while (pp==0||qp==0){
           TreeNode t=queue.poll();
           cnt++;
           if(p.equals(t)){
               pp=cnt;
           }
           if(q.equals(t)){
               qp=cnt;
           }
           if(t!=null){
               queue.offer(t.left);
               queue.offer(t.right);
           }
       }
        while(pp!=qp){
            if(pp<qp){
                qp>>=1;
            }else{
                pp>>=1;
            }
        }
        queue=new LinkedList<>();
        queue.offer(root);
        for(cnt=0;cnt<qp+1;cnt++){
            TreeNode t=queue.poll();
            cnt++;

            if(t!=null){
                queue.offer(t.left);
                queue.offer(t.right);
            }

        }
        return null;
    }
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
