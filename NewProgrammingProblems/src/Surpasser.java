import java.util.Stack;

public class Surpasser {

	public static int surPasser(int[] arr) {
                Stack<Integer> stack = new Stack<Integer> ();
                int index = 0, result = 0;
                while(index < arr.length) {
                        if(stack.isEmpty() || arr[index] <= arr[stack.peek()]) {
                                stack.push(index++);
                        } else {
                                stack.pop();
                                int len = stack.isEmpty() ? index : index - stack.peek()-1;
                                result = Math.max(result, len);
                        }
                }
                return result;
      }	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(surPasser(new int[]{10, 3, 7, 1, 23, 14, 6, 9}));
	}

}
