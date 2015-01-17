
public class CommonUsedSnippet {

	public int findCloesePowerOfTen(int x){
		int y = 1;
		while(y <= x/10){  //if we use 10*y <= x, it might be overflow
			y *= 10;
		}
		return y;
	}
	public int gcd(int a, int b){
		while(a!=b){
			if(a>b) a = a-b;
			else b = b-a;
		}
		return a;
	}
	
	public String convert(int x){
	    
	    if(x<0) return "";
	    
	    StringBuilder sb = new StringBuilder();
	    x++; // 12 -> 13
	    while(x>0){
	        sb.append((char)('A' + ((x-1)%3)));  
	        x = (x-1)/3;
	    }
	    
	    return sb.reverse().toString();
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommonUsedSnippet sol = new CommonUsedSnippet();
		//System.out.println(sol.gcd(18, 24));
		
		for(int i = 0; i <= 100; ++i){
			System.out.println(i+" -> "+sol.convert(i));
		}
	}

}
