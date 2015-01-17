
public class DungeonGame {
	
    public static int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null||dungeon.length==0||dungeon[0].length==0) return 0;
        int M = dungeon.length;
        int N = dungeon[0].length;
        int[][] dp = new int[M][N];
        dp[M-1][N-1] = dungeon[M-1][N-1] >= 0 ? 1: (1-dungeon[M-1][N-1]);
        for(int i = M-2; i >=0; i--){
            dp[i][N-1] = Math.max(1,dp[i+1][N-1] - dungeon[i][N-1]);
        }
        for(int j = N-2; j >=0; j--){
            dp[M-1][j] = Math.max(1, dp[M-1][j+1] - dungeon[M-1][j]);
        }
        for(int i = M-2; i >=0; i--){
            for(int j = N-2; j>=0; j--){
                    dp[i][j] = Math.max(1, Math.min(dp[i+1][j], dp[i][j+1])-dungeon[i][j]);
            }
        }
        return dp[0][0];
    }	

	public static void main(String[] args) {

		int[][] input = new int[][]{
				{-2,-3,3},{-5,-10,1},{10,30,-5}
				
		};
		System.out.println(calculateMinimumHP(input));
		input = new int[][]{
				{-2,-3,3},{-5,-10,1},{10,30,-20}
				
		};
		System.out.println(calculateMinimumHP(input));
		
	}

}
