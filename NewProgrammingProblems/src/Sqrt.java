
public class Sqrt {

    public static int sqrt(int x) {
        // write your code here
        if(x<0) return Integer.MIN_VALUE;
        if(x==0) return 0;
        int left = 1, right = x/2 +1;
        while(left<=right){
            int m = left + (right-left)/2;
            if(m <= x/m && x/(m+1) < m+1 ){
                return m;
            }else if(m < x/m){
                left = m+1;
            }else{
                right = m-1;
            }
        }
        return right;
    }	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqrt(4));
		System.out.println(sqrt(0));
		System.out.println(sqrt(1));
		System.out.println(sqrt(2));
		System.out.println(sqrt(3));
		System.out.println(sqrt(9));
		System.out.println(sqrt(8));
		System.out.println(sqrt(64));
		System.out.println(sqrt(81));
		System.out.println(sqrt(49));
		System.out.println(sqrt(225));
		System.out.println(sqrt(1296));
		System.out.println(sqrt(729));
		System.out.println(sqrt(Integer.MAX_VALUE));
	}

}
