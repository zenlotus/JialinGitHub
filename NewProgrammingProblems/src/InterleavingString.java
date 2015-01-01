
public class InterleavingString {

    public static boolean isInterleave(String s1, String s2, String s3) {
        //dp[i][j]: s1[0....i] and s2[0...j]  could form interleaving string of s3
        if(s1.length()+s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for(int i = 1; i <= s1.length(); ++i){
            if(s1.charAt(i-1)==s3.charAt(i-1) && dp[i-1][0]){
                dp[i][0] = true;
            }else{
                break;
            }
        }
        for(int i = 1; i <= s2.length(); ++i){
            if(s2.charAt(i-1)==s3.charAt(i-1) && dp[0][i-1]){
                dp[0][i] = true;
            }else{
                break;
            }
        }
        for(int i = 1; i <= s1.length(); ++i){
            for(int j = 1; j <= s2.length(); ++j){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    if(s1.charAt(i-1)==s3.charAt(i+j-1)){
                        dp[i][j] = dp[i-1][j] || dp[i][j-1];
                    }else{
                        dp[i][j] = false;
                    }
                }else{
                    if(s1.charAt(i-1)==s3.charAt(i+j-1)){
                        dp[i][j] = dp[i-1][j];
                    }else if(s2.charAt(j-1) == s3.charAt(i+j-1)){
                        dp[i][j] = dp[i][j-1];
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }	
	
	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		s3= "aadbbbaccc";
		System.out.println(isInterleave(s1, s2, s3));

	}

}
