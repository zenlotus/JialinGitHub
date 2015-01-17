import java.util.LinkedList;


public class SlidingWindowMaximum {

	public static int[] maxSlidingWindow(int[] A, int w){
		
		if(A==null|| w <= 0 || A.length < w) return new int[0];
		
		int[] B = new int[A.length-w+1];
		
		LinkedList<Integer> deque = new LinkedList<Integer>();
		for(int i =0; i < w; ++i){
			while(!deque.isEmpty() && A[deque.peekLast()]<=A[i]){
				deque.removeLast();
			}
			deque.offer(i);
		}
		int index = 0;
		B[index++] = A[deque.peekFirst()];
		
		for(int i = w; i < A.length; ++i){
			if(deque.peekFirst() <= i-w){
				deque.pollFirst();
			}
			while(!deque.isEmpty() && A[deque.peekLast()]<=A[i]){
				deque.removeLast();
			}
			deque.offer(i);
			B[index++] = A[deque.peekFirst()];
		}
		return B;
	}
	
	public static void main(String[] args) {
		int[] rev = maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
		for(int x: rev){
			System.out.println(x);
		}
		System.out.println();
		rev = maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 8);
		for(int x: rev){
			System.out.println(x);
		}

		System.out.println();
		rev = maxSlidingWindow(new int[]{8,7,6,5,4,3,2,1}, 4);
		for(int x: rev){
			System.out.println(x);
		}
		
	}

}
