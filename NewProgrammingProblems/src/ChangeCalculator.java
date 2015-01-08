
public class ChangeCalculator {
	
    public static Change getCorrectChange(int cents) {
        /*
          Please implement this method to
          take cents as a parameter
          and return an equal amount in dollars and coins using the minimum number of
          coins possible.
          For example: 164 cents = 1 dollar, 2 quarters, 1 dime and 4 cents.
          Return null if the parameter is negative.

         */
    	  int dollars = 0, quarters=0, dimes=0, nicels=0;
   		  dollars += cents/100;
   		  cents %= 100;
   		  quarters += cents/25;
   		  cents %= 25;
   		  dimes += cents/10;
   		  cents %=10;
   		  nicels += cents/5;
   		  cents %=5;
   		  return new Change(dollars, quarters, dimes, nicels, cents );
             
    }


    // Please do not change this class
    static class Change {
        private final int _dollars;
        private final int _quarters; //25 cents
        private final int _dimes; // 10 cents
        private final int _nickels; // 5 cents
        private final int _cents; // 1 cent


        public Change(int dollars, int quarters, int dimes, int nickels, int cents) {
            _dollars = dollars;
            _quarters = quarters;
            _dimes = dimes;
            _nickels = nickels;
            _cents = cents;
        }


        public int getDollars() {
            return _dollars;
        }


        public int getQuarters() {
            return _quarters;
        }


        public int getDimes() {
            return _dimes;
        }


        public int getNickels() {
            return _nickels;
        }


        public int getCents() {
            return _cents;
        }
    }	

	public static void main(String[] args) {
			Change c = getCorrectChange(164);
			System.out.println(c._dollars);

	}

}
