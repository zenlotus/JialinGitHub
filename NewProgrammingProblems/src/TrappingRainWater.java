
public class TrappingRainWater {

    public static int trap(int[] A) {
        if(A==null||A.length<3) return 0;
        int[] res = new int[A.length];
        res[0] = A[0];
        res[res.length-1] = A[A.length-1];
        
        for(int i = 1; i < res.length-1; ++i){
            res[i] = Math.max(A[i], res[i-1]);
        }
        int sum = 0;
        for(int i = res.length-2; i>=1; i--){
            res[i] = Math.min(res[i], Math.max(A[i], res[i+1]));
            sum += (res[i]-A[i]);
        }
        return sum;
    }
    
    public int trapOnePass(int[] A) {
        if(A==null||A.length<3) return 0;
        int res = 0;
        int l = 0, r = A.length-1;
        while(l<r){
            int min = Math.min(A[l], A[r]);
            if(A[l]==min){
                l++;                
                while(l<r && A[l]<=min){
                    res += min - A[l];
                    l++;
                }
            }else{
                r--;
                while(l<r && A[r] <=min){
                    res += min - A[r];
                    r--;
                }
            }
        }
        return res;
    }    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(A));
	}

}
