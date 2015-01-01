
public class RecoverBinarySearchTreeRecursive {



	
	
	
	
	
	public static void recoverTree(TreeNode root) {
		TreeNode[] pre = new TreeNode[1];
		TreeNode[] res = new TreeNode[2];
		helper(root, pre, res);
		if(res[0]!=null){
			int temp = res[0].val;
			res[0].val = res[1].val;
			res[1].val = temp;
		}
    }
	
	private static void helper(TreeNode node, TreeNode[] pre, TreeNode[] res) {
		if(node==null) return;
		if(node.left!=null){
			helper(node.left, pre, res);
		}
		if(pre[0]!=null && pre[0].val > node.val){
			res[1] = node;
			if(res[0]==null){
				res[0] = pre[0];
			}
		}
		pre[0] = node;
		if(node.right!=null){
			helper(node.right, pre, res);
		}
	}



	public static void main(String[] args) {
		TreeNode node10 = new TreeNode(10);
		TreeNode node5 = new TreeNode(5);
		node10.left = node5;
		TreeNode node15 = new TreeNode(15);
		node10.right = node15;
		TreeNode node0 = new TreeNode(0);
		node5.left = node0;
		TreeNode node8 = new TreeNode(8);
		node5.right = node8;
		node8.left = new TreeNode(6);
		node8.right = new TreeNode(9);
		node0.left = new TreeNode(2);
		node0.right = new TreeNode(-5);
		TreeNode node13 = new TreeNode(13);
		TreeNode node20 = new TreeNode(20);
		node15.left = node13;
		node15.right = node20;
		node13.left = new TreeNode(12);
		node13.right = new TreeNode(14);
		node20.left = new TreeNode(18);
		node20.right = new TreeNode(25);
		
		System.out.println(PrintInOrder(node10));
		recoverTree(node10);
		System.out.println(PrintInOrder(node10));

	}
	private static String PrintInOrder(TreeNode node) {
		if(node==null) return "";
		StringBuilder sb = new StringBuilder();
		String left = PrintInOrder(node.left); 
		if(!left.equals("")){
			sb.append(left).append(",");
		}
		sb.append(node.val);
		String right = PrintInOrder(node.right);
		if(!right.equals("")){
			sb.append(",").append(right);
		}
		
		return sb.toString();
		
	}


}
