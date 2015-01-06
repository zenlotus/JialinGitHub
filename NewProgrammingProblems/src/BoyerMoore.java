import java.util.HashMap;


public class BoyerMoore {

    public int strStr(String source, String target) {
        if(source==null||target==null||source.length()==0||target.length()==0 || source.length() < target.length()) return -1;
        HashMap<Character, Integer> last = new HashMap<Character, Integer>();
        for(int i = 0; i < target.length(); ++i){
            last.put(target.charAt(i), i);
        }
        int M = source.length(), N = target.length();
        for(int i = N-1; i < M; ){
            int j = 0;
            for(;j < N; ++j){
                if(source.charAt(i-j)!=target.charAt(N-1-j)){
                    if(last.containsKey(source.charAt(i-j))){
                        if(last.get(source.charAt(i-j))>N-1-j){
                            i++;
                        }else{
                            i += (N-1-j-last.get(source.charAt(i-j)));
                        }                        
                    }else{
                        i = i-j + N; 
                    }
                    break;
                }
            }
            if(j==N) return i-N +1 ;
        }
        return -1;
    }
	public static void main(String[] args) {
		BoyerMoore sol = new BoyerMoore();
		System.out.println(sol.strStr("abcdabcdefg", "def"));

	}

}
