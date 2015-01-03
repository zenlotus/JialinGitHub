import java.util.ArrayList;
import java.util.Arrays;


public class PrevousPermutation {


    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
    	int i = nums.size()-1;
    	for(; i>0; --i){
    		if(nums.get(i-1)>nums.get(i)){
    			break;
    		}
    	}
		reverse(nums, i, nums.size()-1);
		if(i>0){
			for(int j = i; j < nums.size(); ++j){
				if(nums.get(j)<nums.get(i-1)){
					int tmp = nums.get(j);
					nums.set(j, nums.get(i-1));
					nums.set(i-1, tmp);
					break;
				}
			}
		}
		return nums;
    }	
	private void reverse(ArrayList<Integer> nums, int start, int end) {
		while(start<end){
			int tmp = nums.get(start);
			nums.set(start++, nums.get(end));
			nums.set(end--, tmp);
		}
	}


	public static void main(String[] args) {
		PrevousPermutation sol  = new PrevousPermutation();
		for(int x: sol.previousPermuation(new ArrayList<Integer>(Arrays.asList(1,2,5,3,4)))){
			System.out.println(x);
		}
	}

}
