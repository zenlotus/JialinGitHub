import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ZulilyPhoneInterview {

	List<String> getDuplicateWords(String input){
	     List<String> res = new ArrayList<String>();
	    if(input==null||input.length()==0) return res;
	    String[] words = input.split("\\s+");
	    HashMap<String,Integer> map = new HashMap<String,Integer>();
	    for(String w: words){
	       if(map.containsKey(w)){
	           if(map.get(w)==1){
	              res.add(w);
	              map.put(w,map.get(w)+1);              
	           }
	       }else{
	           map.put(w,1);       
	       }
	    }
	    return res;

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZulilyPhoneInterview sol = new ZulilyPhoneInterview();
		for(String w: sol.getDuplicateWords("java util java tulip ad center googel util")){
			System.out.println(w);
		}
	}

}
