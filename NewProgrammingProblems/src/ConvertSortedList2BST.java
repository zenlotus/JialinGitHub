import java.util.Scanner;

class ListNode{
	int val;
	ListNode next;
	public ListNode(int value){
		val = value;
		next = null;
	}
}
public class ConvertSortedList2BST {

	public static TreeNode sortedListToBST(ListNode head){
		if(head==null) return null;
		ListNode cur = head;
		int count = 0;
		while(cur!=null){
			cur = cur.next;
			count++;
		}
		ListNode[] global = new ListNode[1];
		global[0]=head;
		return helper(global, 0, count-1);
	}
	
	
	
	private static TreeNode helper(ListNode[] global, int start, int end) {
		if(start>end) return null;
		int mid = start + (end-start)/2;
		
		TreeNode left = helper(global, start, mid-1);
		TreeNode root = new TreeNode(global[0].val);
		root.left = left;
		global[0] = global[0].next;
		root.right = helper(global, mid+1, end);
		
		return root;
		
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ListNode head = new ListNode(1);
		ListNode cur = head;
		for(int i = 2; i <= n; ++i){
			cur.next = new ListNode(i);
			cur = cur.next;
		}
		TreeNode res = sortedListToBST(head);
		
		System.out.println(PrintInOrder(res));
		
	}

}
