import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LetterCombinationOfPhoneNumber {
	private static List<List<Character>> mappings;
	static{
		mappings = new ArrayList<List<Character>>(); 
		mappings.add(new ArrayList<Character>());
		mappings.add(new ArrayList<Character>());
		mappings.add(Arrays.asList('a','b','c'));
		mappings.add(Arrays.asList('d','e','f'));
		mappings.add(Arrays.asList('g','h','i'));
		mappings.add(Arrays.asList('j','k','l'));
		mappings.add(Arrays.asList('m','n','o'));
		mappings.add(Arrays.asList('p','q','r','r'));
		mappings.add(Arrays.asList('t','u','v'));
		mappings.add(Arrays.asList('w','x','y','z'));
	}
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits==null|| digits.length()==0) return res;
        res.add("");
        for(int i = 0; i < digits.length(); ++i){
            int cnt = res.size();
            while(cnt-->0){
                String str = res.remove(0);
                for(char c: mappings.get((int)(digits.charAt(i)-'0'))){
                    res.add(str+c);
                }
            }
        }
        return res;
    }
        
	public static void main(String[] args) {
		for(String s: letterCombinations("23")){
			System.out.println(s);
		}

	}

}
