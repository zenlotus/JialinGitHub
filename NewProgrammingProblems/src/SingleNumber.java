import java.util.ArrayList;
import java.util.List;


public class SingleNumber {
    public List<Integer> singleNumberIII(int[] A) {
        int xorVal = A[0];
        for(int i = 1; i < A.length; ++i){
            xorVal ^= A[i];
        }
        int differBit = 0;
        while(differBit<32){
            if( ((xorVal>>differBit) & 1) == 1) break;
            differBit++;
        }
        int a = xorVal;
        int b = xorVal;
        for(int i = 0; i < A.length; ++i){
            if(((A[i]>>differBit)&1)==0){
               a ^= A[i]; 
            }else{
                b ^= A[i];
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        res.add(a);
        res.add(b);
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleNumber sol = new SingleNumber();
		System.out.println(sol.singleNumberIII(new int[]{1,2,2,3,4,4,5,3}));
		System.out.println(sol.singleNumberIII(new int[]{2,2,3,4,4,5,3,7}));
	}

}
