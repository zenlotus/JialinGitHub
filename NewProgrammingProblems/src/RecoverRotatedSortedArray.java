import java.util.ArrayList;
import java.util.Arrays;


public class RecoverRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(5,4,1,2,3));
		recoverRotatedSortedArray(nums);
		for(int x: nums){
			System.out.print(x);
			System.out.print(",");
		}
		System.out.println();
	}
	
	
    public static void recoverRotatedSortedArray(ArrayList<Integer> nums) {
    	if(nums==null || nums.size()<2) return;
    	int left = 0, right = nums.size()-1; 
    	int k = -1;
    	while(left<right){
    		int mid = left+ (right-left)/2;
    		if(nums.get(mid)> nums.get(right)){
        		if(mid+1 < nums.size() && nums.get(mid)>nums.get(mid+1)){
        			k = mid+1;
        			break;
        		}else{
        			left = mid+1;
        		}
    		}else{
    			if(mid-1>0 && nums.get(mid)<nums.get(mid-1)){
    				k = mid;
    				break;
    			}else{
    				right = mid-1;
    			}
    		}
    	}
    	if(k!=-1){
    		reverse(nums, 0, k-1);
    		reverse(nums,k,nums.size()-1);
    		reverse(nums,0,nums.size()-1);
    	}
    }

	private static void reverse(ArrayList<Integer> nums, int start, int end) {
		while(start<end){
			int tmp = nums.get(start);
			nums.set(start++, nums.get(end));
			nums.set(end--, tmp);
		}
	}	

}
