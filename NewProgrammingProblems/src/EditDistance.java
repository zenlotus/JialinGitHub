
public class EditDistance {
	
    public static int minDistance(String word1, String word2) {
        if(word1==null&&word2==null) return 0;
        
        if(word1==null || word1.length()==0) return word2.length();
        
        if(word2==null||word2.length()==0) return word1.length();
        
        int res[] = new int[word1.length()+1];
        int nextRow[] = new int[word1.length()+1];
        for(int i =0; i <= word1.length(); ++i) res[i] = i;
        for(int i = 0; i < word2.length(); i++){
            
            nextRow[0] = i+1;
            for(int j = 0; j < word1.length(); ++j){
                if(word2.charAt(i)==word1.charAt(j)){
                    nextRow[j+1] = res[j];
                }else{
                    nextRow[j+1] = Math.min(Math.min(res[j+1], nextRow[j]),res[j])+1;
                }
            }
            int[] tmp = nextRow;
            nextRow = res;
            res = tmp;
        }
        return res[word1.length()];
    }	

	public static void main(String[] args) {
		System.out.println(minDistance("a", "a"));

	}

}
