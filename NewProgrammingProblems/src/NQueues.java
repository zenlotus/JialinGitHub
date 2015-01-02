import java.util.ArrayList;
import java.util.List;


public class NQueues {
	
	
    public List<String[]> solveNQueens(int n) {
        List<String[]> res = new ArrayList<String[]>();
        if(n<=0) return res;
        char[][] board = new char[n][n];
        for(int i = 0; i < n; ++i){
        	for(int j = 0; j < n; ++j){
        		board[i][j] = '.';
        	}
        }
        helper(board, res, 0,n);
        return res;
        
    }	

	private void helper(char[][] board, List<String[]> res, int row, int n) {
		if(row>=n){
			String[] bd = new String[n];
			for(int i = 0; i < n; i++){
				bd[i] = new String(board[i]);
			}
			res.add(bd);
		}
		for(int i = 0; i < n; ++i){
			if(isValid(board, row, i, n)){
				board[row][i] = 'Q';
				helper(board, res, row+1, n);
				board[row][i] = '.';
			}
		}
	}
	
	private boolean isValid(char[][] board, int row, int column, int n) {
		for(int i = 0; i < row; ++i){
			if(board[i][column]=='Q') return false;
			int offset = row - i;
			if(column-offset >=0 && board[i][column-offset]=='Q') return false;
			if(column+offset < n && board[i][column+offset]=='Q') return false;
		}
		
		return true;
	}
	
    public int totalNQueens(int n) {
        int[] res = new int[1];
        if(n<=0) return 0;
        char[][] board = new char[n][n];
        for(int i = 0; i < n; ++i){
        	for(int j = 0; j < n; ++j){
        		board[i][j] = '.';
        	}
        }
        helper2(board, res, 0,n);
        return res[0];
        
    }	
	private void helper2(char[][] board, int[] res, int row, int n) {
		if(row==n){
			res[0]++;
		}
		for(int i = 0; i < n; ++i){
			if(isValid(board, row, i, n)){
				board[row][i] = 'Q';
				helper2(board, res, row+1, n);
				board[row][i] = '.';
			}
		}
	}	

	public static void main(String[] args) {
		NQueues sol = new NQueues();
//		for(String[] board: sol.solveNQueens(8) ){
//			for(String row: board){
//				System.out.println(row);
//			}
//			System.out.println();
//		}
		System.out.println(sol.totalNQueens(4));
		System.out.println(sol.totalNQueens(6));
		System.out.println(sol.totalNQueens(8));
	}

}
