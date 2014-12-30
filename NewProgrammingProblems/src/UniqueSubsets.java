import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class UniqueSubsets {

	public static void main(String[] args) {
		

		ArrayList<Integer> S = new ArrayList<Integer>(Arrays.asList(1,2,2,2));
		for(ArrayList<Integer> subset: subsetsWithDupRecursive(S)){
			for(int v: subset){
				System.out.print(v);
				System.out.print(",");
			}
			System.out.println();
		}		

	}
	
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		res.add(new ArrayList<Integer>());
		if(S==null) {
			return res; 
		}
		Collections.sort(S);
	    int preCnt = 0;	
		for(int i = 0; i < S.size(); ++i){
		    
			int cnt = res.size();
			
			for(int j = preCnt; j < cnt; ++j){
				ArrayList<Integer> cur = new ArrayList<Integer>(res.get(j));
				cur.add(S.get(i));
				res.add(cur);
			}
			if(i<S.size()-1 && S.get(i) == S.get(i+1)){
			    preCnt = cnt;
			}else{
			    preCnt = 0;
			}
		}
		return res;
    }
	private static ArrayList<ArrayList<Integer>> subsetsWithDupRecursive(ArrayList<Integer> S, int end, int[] lastSize) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(S==null||end<0){
			res.add(new ArrayList<Integer>());
			lastSize[0] = 0;
			return res; 
		}
		
		res.addAll(subsetsWithDupRecursive(S, end-1, lastSize));
		
		int cnt = res.size();
		for(int i = lastSize[0]; i < cnt; ++i){
			ArrayList<Integer> cur = new ArrayList<Integer>();
			cur.addAll(res.get(i));
			cur.add(S.get(end));
			res.add(cur);
		}
		if(end<S.size()-1 && S.get(end)==S.get(end+1)){
			lastSize[0] = cnt;
		}else{
			lastSize[0] = 0;
		}
		return res;
	}
	/**
	 * Recursive way
	 * @param S
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> subsetsWithDupRecursive(ArrayList<Integer> S) {
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(S==null) {
			res.add(new ArrayList<Integer>());
			return res; 
		}
		Collections.sort(S);
		
		return subsetsWithDupRecursive(S,S.size()-1, new int[]{0});
    }    
    

}
