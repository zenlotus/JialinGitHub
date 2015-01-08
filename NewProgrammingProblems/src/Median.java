
public class Median {

    public int median(int[] nums) {
        if(nums==null||nums.length==0) return Integer.MIN_VALUE;
        int numsBefore = (nums.length&1)==1 ? nums.length/2 : nums.length/2-1;
        int saved = numsBefore;
        int left = 0, right = nums.length-1;
        while(left<=right){
            //int idx =  (int)(Math.random() * (right-left+1)) + left;
            //swap(nums,idx,right);
            int i = left;
            int j = right-1;
            while(i <= j){
                if(nums[i]>nums[right]){
                    swap(nums,i,j);
                    --j;
                }else{
                    ++i;
                }
            }
            swap(nums, i, right);
            if(i-left==numsBefore){
                return nums[i];
            }else if(i-left>numsBefore){
                right = i-1;                
            }else{
            	numsBefore = numsBefore - (i-left)-1;
                left = i+1;
            }
        }
        return nums[left];
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[j];
        nums[j]=nums[i];
        nums[i] = tmp;
    }	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Median sol = new Median();
		System.out.println(sol.median(new int[]{-1,-2,-3,-100,-1,-50}));
		System.out.println(sol.median(new int[]{4,5,1,2,3}));
		
	}

}
