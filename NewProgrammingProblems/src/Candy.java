
/**
 * Leetcode problem: candy
 * @author jijiao
 *
 */
public class Candy {

    public static int candy(int[] ratings) {
        if(ratings==null||ratings.length==0) return 0;
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        for(int i = 1; i < candy.length; ++i){
            if(ratings[i-1]>= ratings[i]){
                candy[i] = 1;
            }else{
                candy[i] = candy[i-1]+1;
            }
        }
        
        for(int i = candy.length-2; i >=0; --i){
            if(ratings[i] > ratings[i+1]){
                candy[i] = Math.max(candy[i], candy[i+1]+1);
            }
        }
        
        
        int sum = 0;
        for(int c: candy){
            sum += c;
            System.out.print(c+",");
        }
        System.out.println();
        return sum;
    }	
	public static void main(String[] args) {

		int[] ratings = {2,2};
		System.out.println(candy(ratings));

	}

}
