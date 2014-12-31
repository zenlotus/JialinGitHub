

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val){
		this.val = val;
		left = null;
		right = null;
	}
}


public class FindPrecedentInBST {

	
	
	public TreeNode findPrecedent(TreeNode root, TreeNode node){
		TreeNode pre = null;
		TreeNode cur = node;
		while(cur!=null){
			if(node.val <= cur.val){
				cur = cur.left;
			}else{
				pre = cur;
				cur = cur.right;
			}
		}
		return pre;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(11);
		root.left = new TreeNode(6);
		
	}
	
	
	

}
