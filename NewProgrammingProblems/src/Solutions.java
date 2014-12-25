import java.util.Scanner;


/* 
 * Served as my saved code. 
 * 
 */

public class Solutions {
	/*
	 * Leetcode problem: Excel Sheet Column Title
	 * 
	 * @author Jialin  
	 */
	
	
	
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        if(n<=0) return res.toString();
        while(n>0){
            res.append((char)('A'+ ((n-1)%26)));
            n = (n-1)/26;
        }
        return res.reverse().toString();
    }
    /*
     * POJ 1160   - http://poj.org/problem?id=1160
     */
    public void PostOffice(){
    	Scanner in = new Scanner(System.in);
    }

}
