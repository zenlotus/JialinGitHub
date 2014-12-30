import java.util.Scanner;


public class TriggerEvent {

	
	
	public static boolean trigger(int n){
		while(n-->0){
			if(Math.random()>0.5) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int trueCnt = 0;
		int expNum = 10000;
		Scanner in = new Scanner(System.in);
		int N;
		while((N=in.nextInt())!=0){
			for(int i = 0; i < expNum; ++i){
				if(trigger(N)) trueCnt++;
			}
			System.out.println(trueCnt/(double)expNum);
			trueCnt = 0;
		}
		
	}

}
