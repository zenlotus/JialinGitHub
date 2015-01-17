
public class DivideTwoNumbers {

    public static int divide(int dividend, int divisor) {
        if(divisor==0) return Integer.MIN_VALUE;
        int sign = 1;
        if((dividend>0 && divisor < 0)||(dividend<0 && divisor >0)) sign = -1;
        long ldividend = dividend;
        ldividend = Math.abs(ldividend);
        long ldivisor = divisor;
        ldivisor = Math.abs(ldivisor);
        long upper = 1;
        while(upper*ldivisor<ldividend){
            upper *=2;
        }
        long lower = upper/2;
        while(lower <= upper){
            long m = lower + (upper-lower)/2;
            if(ldivisor*m <= ldividend && ldivisor*(m+1) > ldividend){
                return sign* (int)m;
            }else if(ldividend < ldivisor*m){
                upper = m-1;
            }else{
                lower = m+1;
            }
        }
        return sign*(int)lower;
        
    }	
	
	public static void main(String[] args) {
		System.out.println(divide(-1,1));

	}

}
