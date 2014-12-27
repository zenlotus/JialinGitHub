import java.util.HashMap;
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
   
   public void AllInAllDP(){
	   Scanner in = new Scanner(System.in);
	   while(in.hasNext()){
		   String s = in.next();
		   String t = in.next();
		   boolean[][] dp = new boolean[s.length()][t.length()];  //dp[i][j]:  s[0...i-1] is in t[0...j-1]
		   HashMap<Character, Integer> mem = new HashMap<Character, Integer>();
		   dp[0][0] = s.charAt(0)==t.charAt(0);
		   for(int i = 1; i < t.length(); ++i){
			   dp[0][i] = dp[0][i-1] || (s.charAt(0)==t.charAt(i));
		   }
		   for(int i = 1; i < s.length(); ++i){
			   dp[i][i] = dp[i-1][i-1] && (s.charAt(i)==t.charAt(i));
			   for(int j = i+1; j < t.length(); ++j){
				   mem.clear();
				   for(int k = i; k <= j; ++k){
					   if(mem.containsKey(t.charAt(k))){
						   mem.put(t.charAt(k), mem.get(t.charAt(k))+1);
					   }else{
						   mem.put(t.charAt(k), 1);
					   }
				   }
				   dp[i][j] = false;
				   for(int k = i-1; k < j; ++k){
					   dp[i][j] = dp[i][j] || (dp[i-1][k] && mem.containsKey(s.charAt(i)));
					   if(dp[i][j]){
						   break;
					   }
					   if(mem.get(t.charAt(k+1))==1){
						  mem.remove(t.charAt(k+1)); 
					   }else{
						   mem.put(t.charAt(k+1), mem.get(t.charAt(k+1))-1);
					   }
				   }
			   }
		   }
		   if(dp[s.length()-1][t.length()-1]) System.out.println("Yes");
		   else System.out.println("No");
	   }
   }

   public void AllInAllNonDP2Pointers(){
	   Scanner in = new Scanner(System.in);
	   while(in.hasNext()){
		   String s = in.next();
		   String t = in.next();
		   if(s.length()>t.length()){
			   System.out.println("No");
			   continue;
		   }
		   int s_left = 0, s_right = s.length()-1;
		   int t_left = 0, t_right = t.length()-1;
		   while(t_left <= t_right && s_left <= s_right){
			   if(t.charAt(t_left)==s.charAt(s_left)){
				   s_left++;
			   }
			   t_left++;
			   if(t.charAt(t_right)==s.charAt(s_right)){
				   s_right--;
			   }
			   t_right--;
		   }
		   if(s_left>s_right){
			   System.out.println("Yes");
		   }else{
			   System.out.println("No");
		   }
	   }	   
   }
   
   public void AllInAllNonDP1Pointer(){
	   Scanner in = new Scanner(System.in);
	   while(in.hasNext()){
		   String s = in.next();
		   String t = in.next();
		   if(s.length()>t.length()){
			   System.out.println("No");
			   continue;
		   }
		   int si = 0;
		   int ti = 0;
		   while(si < s.length() && ti < t.length()){
			   if(t.charAt(ti)==s.charAt(si)){
				   si++;
			   }
			   ti++;
		   }
		   if(si>=s.length()){
			   System.out.println("Yes");
		   }else{
			   System.out.println("No");
		   }
	   }	   
   }
   
   public void TriTiling(){
	   
	   int[] D = new int[31];
	   D[0] = 1;
	   D[2] = 3;
	   for(int i = 4; i <=30; i+=2){
		   D[i] = 4*D[i-2] - D[i-4];
	   }
	   Scanner in = new Scanner(System.in);
	   int n;
	   while((n=in.nextInt())!=-1){
		   System.out.println(D[n]);
	   }
   }
    

}
