import java.util.ArrayList;
import java.util.Arrays;


public class VMWareTimedCodingTest {

	/**
	 *  This problem essentially is to find a subarray that it has more 0's than 1's and difference of their numbers is the largest.
	 *  if there is no subarray with more 0's than 1's , we do not flip  (which only happened when the input are all 1's)
	 *  
	 *  if we treat the 0's as -1, then the problem become to find the subarray with minimal sum (and the subarray could be an empty array)
	 *  
	 *   
	 */
	static int bitFlip(int[] arr){
		int min = 0;    //global min
		int minEndingHere = 0; //minimal sum of the subarray ending with the current index (aks, local min)
		int minEndingHereStart = 0; //the starting index of the minimal sum subarray ending with the current index 
		int L = 0, R = 0;
		for(int i = 0; i < arr.length; ++i){
			int tmp = arr[i] == 0 ? -1:arr[i];  //if arr[i] is 0, we treat it as -1; 
			if(minEndingHere+tmp < 0){
				minEndingHere = minEndingHere+tmp;  //update the minEndingHere
			}else{
				minEndingHereStart = i+1;  //change the starting index to next index 
				minEndingHere = 0;
			}
			if(minEndingHere < min){ //if the local min is smaller than global min, update the global variables
				min = minEndingHere;
				L = minEndingHereStart;
				R = i;
			}
		}
		int cnt = 0;
		System.out.println(L+","+R);
		if(min<0){
			for(int i =0; i < L; ++i){
				cnt += arr[i];
			}
			cnt +=  (R-L+1-min)/2;  //  (R-L+1-min)/2  is the total number of 1's after flip that subarray of arr[L...R]
			for(int i =R+1; i < arr.length; ++i){
				cnt += arr[i];
			}
		}else{
			for(int i =0; i < arr.length; ++i){
				cnt += arr[i];
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
//		System.out.println(bitFlip(new int[]{1,0,0,1,0,0,1,0}));
//		System.out.println(bitFlip(new int[]{1,1,1,1,1,1,1,0}));
//		System.out.println(bitFlip(new int[]{1,1,1,1,1,1,1,1}));
//		System.out.println(bitFlip(new int[]{0,0,0,0,0,0,0,0}));
//		System.out.println(bitFlip(new int[]{0,1,1,0,0,0,0,0}));
//		System.out.println(bitFlip(new int[]{0}));
//		System.out.println(bitFlip(new int[]{1}));
//		System.out.println(bitFlip(new int[]{1,0,1,0,1,}));
//		System.out.println(bitFlip(new int[]{1,0,1,0,1,0,1,0}));

		int[] x = new int[]{1,2,3};
		ArrayList<Integer> y = new ArrayList<Integer>(Arrays.asList((Integer[])Arrays.asList(x).toArray()));
		
		for(int i: y){
			System.out.println(i);
		}

	}

}
