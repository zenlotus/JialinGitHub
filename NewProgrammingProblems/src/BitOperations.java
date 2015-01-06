
public class BitOperations {

	
	public static int getMaxInt(){
		return (1<<31)-1;
	}
	
	public static int getMaxInt2(){
		return ~(1<<31);
	}
	
	public static int getPowerOfTwo(int n){//n > 0
		return 2 << (n-1);//2µÄn´Î·½
	}	
	
	public static void main(String[] args) {

		System.out.println(Integer.MAX_VALUE);
		System.out.println(getMaxInt());
		System.out.println(getMaxInt2());
		
		System.out.println((-5)>>31);
		System.out.println((-6)>>31);
		
		System.out.println(getPowerOfTwo(8));
	}

}
