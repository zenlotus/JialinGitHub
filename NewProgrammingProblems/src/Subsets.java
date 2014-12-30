import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * Lintcode Subsets 
 * 
 * @author jijiao
 *
 */
public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subsets app = new Subsets();
		ArrayList<Integer> S = new ArrayList<Integer>(Arrays.asList(1,2,3));
		for(ArrayList<Integer> subset: app.subsetsIterative(S)){
			for(int v: subset){
				System.out.print(v);
				System.out.print(",");
			}
			System.out.println();
		}
	}
	
	
	private ArrayList<ArrayList<Integer>> subsetsRecursive(ArrayList<Integer> S, int end) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(S==null||end<0){
			res.add(new ArrayList<Integer>());
			return res; 
		}
		res.addAll(subsetsRecursive(S, end-1));
		int cnt = res.size();
		for(int i = 0; i < cnt; ++i){
			ArrayList<Integer> cur = new ArrayList<Integer>();
			cur.addAll(res.get(i));
			cur.add(S.get(end));
			res.add(cur);
		}
		return res;
	}
	/**
	 * Recursive way
	 * @param S
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> subsetsRecursive(ArrayList<Integer> S) {
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(S==null) {
			res.add(new ArrayList<Integer>());
			return res; 
		}
		Collections.sort(S);
		return subsetsRecursive(S,S.size()-1);
    }
	
	public ArrayList<ArrayList<Integer>> subsetsIterative(ArrayList<Integer> S){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		res.add(new ArrayList<Integer>());
		if(S==null) {
			return res; 
		}
		Collections.sort(S);
		
		for(int i = 0; i < S.size(); ++i){
			int cnt = res.size();
			for(int j = 0; j < cnt; ++j){
				ArrayList<Integer> cur = new ArrayList<Integer>(res.get(j));
				cur.add(S.get(i));
				res.add(cur);
			}
		}
		return res;
		
	}
	
	
	
	

}
