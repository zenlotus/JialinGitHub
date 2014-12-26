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
   			cost[i][i] = 0;
   			for(int j = i+1; j < V; j++){
   				cost[i][j] = cost[i][j-1] + (pos[j] - pos[(j+i)/2]); 
   			}
   		}
   		
   		for(int i = 0; i < V; i++){
   			dp[0][i] = cost[0][i];
   		}
   		
   		for(int i = 1; i < P; i++){
   			for(int j = i; j < V; j++){
   				dp[i][j] = Integer.MAX_VALUE;
   				for(int k = i-1; k <= j-1; k++){
   					dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + cost[k+1][j]);
   				}
   			}
   		}
   		System.out.println(dp[P-1][V-1]);
   }

}
