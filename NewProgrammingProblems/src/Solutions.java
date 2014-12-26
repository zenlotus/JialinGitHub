import java.util.Scanner;


/* 
 * Served as my saved code. 
 * 
 */

public class Solutions {
	/*
	 * Leetcode problem: Excel Sheet Column Title
	 * 
	 * @author Jialin  
	 */
	
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        if(n<=0) return res.toString();
        while(n>0){
            res.append((char)('A'+ ((n-1)%26)));
            n = (n-1)/26;
        }
        return res.reverse().toString();
    }	
    
   public void PostOffice(){
   		Scanner in = new Scanner(System.in);
   		int V = in.nextInt();
   		int P = in.nextInt();
   		int pos[] = new int[V];
   		for(int i =0; i < V; ++i){
   			pos[i] = in.nextInt();
   		}
   		
   		int[][] dp = new int[P][V];
   		int[][] cost = new int[V][V];
   		for(int i = 0; i < V; i++){
   			cost[i][0] = 0;
   			for(int j = 1; j < V; j++){
   				
   			}
   		}
   		
   		
   }

}
