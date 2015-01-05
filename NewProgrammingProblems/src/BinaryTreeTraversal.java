import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;


public class BinaryTreeTraversal {

	
    public static ArrayList<Integer> inorderTraversalIterative(TreeNode root) {
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root==null) return res;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }	
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root==null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                TreeNode peekNode = stack.peek();
                if(peekNode.right!=null && peekNode.right!=pre){
                    cur = peekNode.right;
                }else{
                    res.add(peekNode.val);
                    pre = peekNode;
                    stack.pop();
                }
            }
        }
        return res;
    }	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		
		ArrayList<Integer> res = postorderTraversal(n1);
		for(int x: res){
			System.out.println(x);
		}
		
	}

}
