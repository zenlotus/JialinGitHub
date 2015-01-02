import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
    	List<List<String>> res = new ArrayList<List<String>>();
    	if(s==null||s.length() ==0) return res;
    	int n = s.length();
    	boolean[][] dp = new boolean[n][n];
    	for(int i = n-1; i >=0; --i){
    		dp[i][i] = true;
    		for(int j = 1; j < n-i; ++j){
    			dp[i][i+j] = s.charAt(i)==s.charAt(i+j);
    			if(j>2){
    				dp[i][i+j] = dp[i][i+j] && dp[i+1][i+j-1]; 
    			}
    		}
    	}
    	helper(dp, 0, res, new ArrayList<String>(),n,s);
    	return res;
    }	
    
	private void helper(boolean[][] dp, int start, List<List<String>> res,
			ArrayList<String> item, int n, String s) {
		if(start >= n){
			res.add(new ArrayList<String>(item));  //must create a new copy
			return;
		}
		for(int i = start; i < n; ++i){
			if(dp[start][i]){
				String str = s.substring(start, i+1);
				item.add(str);
				helper(dp, i+1, res, item, n, s);
				item.remove(item.size()-1);
			}
		}
	}

	public static void main(String[] args) {
		PalindromePartitioning sol = new PalindromePartitioning();
		Scanner in = new Scanner(System.in);
		
		String s = null;
		while( !(s=in.next()).equals("EXIT")){
			for(List<String> list: sol.partition(s)){
				for(String str: list){
					System.out.print(str+",");
				}
				System.out.println();
				
			}
		}

	}

}
