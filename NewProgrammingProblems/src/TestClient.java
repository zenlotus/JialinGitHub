import java.util.ArrayList;
import java.util.Arrays;


public class TestClient {

	
	private static Solutions sol = new Solutions();
	
	private static void TestConvertToTitle(){
		System.out.println(sol.convertToTitle(58));
	}
	
	
	
	public static void main(String[] args) {
		//TestConvertToTitle();
		//sol.PostOffice();
		//sol.TriTiling();
		//sol.PalindromeOptimized();
		//int[] A ={12,3,7,4,5,13,2,8,4,7,6,5,7}; 
				// {16,16,3,5,16,16,16,16,16,16,16,16,16,16,16,16,16};
		//System.out.println(sol.backPack(90, A));
//		System.out.println(sol.hashCode("abcd".toCharArray(), 100));
//		System.out.println(sol.hashCode("abcd".toCharArray(), 1000));
		
		//ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(-5,3,-4,0,0,0,-1,20,1,1,-1,-1,-1,-1,-1));
		//ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 8,1, 1));
		//ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(-5,-4));
				//new ArrayList<Integer>();
//		for(long x :sol.productExcludeItself(A)){
//			System.out.println(x);
//		}
		//System.out.println(sol.maxDiffSubArrays(A));
		
		//sol.UltraQuickSort();
		System.out.println(sol.backPackII(10, new int[]{2,3,5,7}, new int[]{1,5,2,4}));		
		
	}

}
