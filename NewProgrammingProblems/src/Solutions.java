import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;


/* 
 * Served as my saved code. 
 * 
 */
 class UndirectedGraphNode {
     int label;
     ArrayList<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 };
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
   
   // POJ 
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
    
   //POJ 1159
   public void Palindrome(){
	   Scanner in = new Scanner(System.in);
	   int N = in.nextInt();
	   String s = in.next();
	   int[][] dp = new int[N][N];
	   for(int i = N-1; i >=0; --i){
		   dp[i][i] = 0;
		   for(int j = i+1; j < N; ++j){
			   if(s.charAt(i)!=s.charAt(j)){
				   dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1])+1;
			   }else{
				   dp[i][j] = i+1 > j-1 ? 0: dp[i+1][j-1];
			   }
		   }
	   }
	   System.out.println(dp[0][N-1]);
   }
   
   public void PalindromeOptimized(){
	   Scanner in = new Scanner(System.in);
	   int N = in.nextInt();
	   String s = in.next();
	   int[] lastRow = new int[N];
	   int[] thisRow = new int[N];
	   for(int i = N-1; i >=0; --i){
		   thisRow[i] = 0;
		   for(int j = i+1; j < N; ++j){
			   if(s.charAt(i)!=s.charAt(j)){
				   thisRow[j] = Math.min(lastRow[j], thisRow[j-1])+1;
			   }else{
				   thisRow[j] = i+1 > j-1 ? 0: lastRow[j-1];
			   }
		   }
		   int[] tmp = lastRow;
		   lastRow = thisRow;
		   thisRow = tmp;
	   }
	   System.out.println(lastRow[N-1]);
   }
   
   
   //Lintcode - Backpack
   
   private int backPack(int m, int sum, int[] A, int start, int[] max){
	   if(sum < m){
		   max[0] = Math.max(max[0], sum);
		   if(start>=A.length) return sum;
           for(int i = start; i < A.length; i++){
        	   if(sum+A[i]<=m){
        		   int val = backPack(m, sum+A[i], A, i+1, max);
        		   if(val==m){
        			   max[0] = m;
        			   return m;
        		   }
        	   }
           }
           return max[0];
       }else if(sum==m){
    	   max[0] = m;
           return m;
       }else{
    	   return max[0];
       }
   }
   
   public int backPack(int m, int[] A) {
	   if(A==null||A.length==0||m==0) return 0;
       Arrays.sort(A);
       int[] max = new int[1];
       max[0] = 0;
       backPack(m,0,A,0,max);
       return max[0];
   }   
   
   public int backPackDP(int m, int[] A) {
	   if(A==null||A.length==0||m==0) return 0;
       boolean[][] dp = new boolean[A.length+1][m+1];
       dp[0][0] = true;
       for(int i = 1; i <= A.length ; ++i){
    	   dp[i][0] = true;  //this is tricky
    	   for(int j = 1; j <= m; ++j){
    		   dp[i][j] = dp[i-1][j];
    		   if(j-A[i-1]>=0){
    			   dp[i][j] = dp[i][j] || dp[i-1][j-A[i-1]];
    		   }
    	   }
       }
       for(int i = m; i>=0; i--){
    	   if(dp[A.length][i]) return i;
       }
       return 0;
   }

   public int backPackDPOptimized(int m, int[] A) {
	   if(A==null||A.length==0||m==0) return 0;
       boolean[] dp = new boolean[m+1];
       dp[0] = true;
       for(int i = 1; i <= A.length ; ++i){
    	   for(int j = m; j >=0; --j){
    		   if(j-A[i-1]>=0){
    			   dp[j] = dp[j] || dp[j-A[i-1]];
    		   }
    	   }
       }
       for(int i = m; i>=0; i--){
    	   if(dp[i]) return i;
       }
       return 0;
   }
   
   //lintcode backpack II
   
   public int backPackII(int m, int[] A, int V[]) {
	   if(A==null||A.length==0||m==0 || V==null || V.length!=A.length) return 0;
      int[][] dp = new int[A.length+1][m+1];
      for(int i = 0; i <=m; ++i){
    	  dp[0][i] = 0;
      }
      
      for(int i = 1; i <= A.length ; ++i){
   	   dp[i][0] = 0;  //this is tricky
   	   for(int j = 1; j <= m; ++j){
   		   
   		   if(A[i-1]<=j){
   			   dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-A[i-1]] + V[i-1]); 
   		   }else{
   			   dp[i][j] = dp[i-1][j];
   		   }
   	   }
      }
      return dp[A.length][m];
   
   }
   
   
   
   //lintcode hashcode
   public int hashCode(char[] key,int HASH_SIZE) {
       // write your code here
       long sum = 0;
       long base = 1;
       for(int i = key.length-1; i >=0; --i){
    	   sum += (key[i]*base)%(long)HASH_SIZE;
           base = (base*33)%(long)HASH_SIZE;
       }
       return (int) (sum);
       
   }
   
   public int hashCode2(char[] key, int HASH_SIZE){
	    long sum = 0;
	    for(int i = 0; i < key.length; i++){
	    	sum = ((sum*33)%HASH_SIZE + key[i]%HASH_SIZE)%HASH_SIZE;
	    }
	    return (int) sum;
   }
   
   //lintcode clone graph
   public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
       if(node==null) return node;
       HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
       LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
       queue.offer(node);
       UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
       map.put(node, copy);
       while(!queue.isEmpty()){
           UndirectedGraphNode cur = queue.poll();
           for(UndirectedGraphNode n: cur.neighbors){
               if(!map.containsKey(n)){
                   copy = new UndirectedGraphNode(n.label);
                   map.put(n,copy);
                   queue.offer(n);
               }
               map.get(cur).neighbors.add(map.get(n));
           }
       }
       return map.get(node);
       
   }   
   
   //lintcode: Product of Array Excluding itselft
   public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
       ArrayList<Long> res = new ArrayList<Long>();
       if(A==null||A.size()<2) return res;
       res.add(1L);
       for(int i =1; i < A.size(); ++i){
           res.add(res.get(i-1)*(long)A.get(i-1));
       }
       long temp = 1;
       for(int i = A.size()-1; i>=0; --i){
           res.set(i, res.get(i)* temp);
           temp *= (long) A.get(i);
       }
       return res;
   }
   
   //lintcode: Maximum Subarray Difference
   public int maxDiffSubArrays(ArrayList<Integer> nums) {
	   if(nums==null||nums.size()<2) return 0;
	   int[] resMax = new int[nums.size()];
	   int[] resMin = new int[nums.size()];
	   
	   int globalMax = nums.get(0);
	   int localMax = nums.get(0);
	   int globalMin = nums.get(0);
	   int localMin = nums.get(0);
	   
	   resMax[0] = nums.get(0);
	   resMin[0] = nums.get(0);
	   for(int i = 1; i < nums.size(); ++i){
		   localMax = Math.max(localMax+nums.get(i), nums.get(i));
		   globalMax = Math.max(localMax, globalMax);
		   resMax[i] = globalMax;

		   localMin = Math.min(localMin+nums.get(i), nums.get(i));
		   globalMin = Math.min(localMin, globalMin);
		   resMin[i] = globalMin;
		   
	   }
	   
	   localMin = nums.get(nums.size()-1);
	   globalMin = nums.get(nums.size()-1);
	   localMax = nums.get(nums.size()-1);
	   globalMax = nums.get(nums.size()-1);

	   int result = Integer.MIN_VALUE;
	   
	   for(int i = nums.size()-2; i>=0; --i){
		   
		   result = Math.max(result, Math.abs(resMax[i]-globalMin));
		   result = Math.max(result, Math.abs(resMin[i]-globalMax));
		   
		   localMin = Math.min(localMin+nums.get(i), nums.get(i));
		   globalMin = Math.min(globalMin, localMin);
		   
		   localMax = Math.max(localMax+nums.get(i), nums.get(i));
		   globalMax = Math.max(globalMax, localMax);
		   
		   
		   
	   }
	   return result;
	   
   }
   
   //POJ - 2299 Ultra-QuickSort or Inversion count
   public void UltraQuickSort(){
	   Scanner in = new Scanner(System.in);
	   int[] A = new int[499999];
	   int n;
	   while((n=in.nextInt())!=0){
		   for(int i = 0; i < n; ++i){
			   A[i] = in.nextInt(); 
		   }
		   System.out.println(GetInversionsCount(A,0, n-1));
	   }
   }

   
private int GetInversionsCount(int[] A, int start, int end) {
	if(start==end) return 0;
	int mid = start + (end-start)/2;
	int inv = GetInversionsCount(A, start, mid) + GetInversionsCount(A, mid+1, end);
	int[] temp = new int[end-start+1];
	int i = start, j = mid+1, k = 0;

	while(i <=mid && j <=end){
		if(A[i]<=A[j]){
			temp[k++] = A[i++];
		}else{
			temp[k++] = A[j++];
			inv += mid - i+1;
		}
	}
	while(mid>=i){
		A[end--] = A[mid--];
	}
	while(k>0){
		k--;
		A[start+k] = temp[k];
	}
	return inv;
}

   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
