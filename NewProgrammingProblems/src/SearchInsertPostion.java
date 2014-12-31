import java.util.ArrayList;


public class SearchInsertPostion {

    public int searchInsert(ArrayList<Integer> A, int target) {
        if(A==null||A.size()==0) return 0;
        int left = 0, right = A.size()-1;
        while(left<=right){
            int m = left + (right-left)/2;
            if(A.get(m)==target){
                return m;
            }else if(A.get(m) > target){
                right = m-1;
            }else{
                left = m+1;
            }
        }
        return left;  //note: must return left,  NOT right
    }	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
