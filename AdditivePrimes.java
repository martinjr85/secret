import java.util.ArrayList;

/**
 * This class checks for additive-ness of prime numbers that are less than the integer passed as an argument to the main() method.
 * I did not use OOP because it seemed like overkill for the task.
 * @author jmarti12
 *
 */
public class AdditivePrimes{

	/**
	 * This constant represents the meaning of life, the universe, and everything
	 */
    private static final int MEANING_OF_LIFE = 42;

    /**
     * Main method that is executed when the program runs
     * @param args a single integer which represents the ceiling of prime numbers to fetch
     */
    public static void main(String []args){
        try{
            int arg = Integer.parseInt(args[0]);
            //check to make sure the argument is valid and throw an error if it is not
            if(arg <= 3 || args.length > 1){
                throw new Exception();
            }
            else{
                boolean result = isAdditive(arg);//check to see if all primes less than the argument are additive
                System.out.println("Result is "+result);
                //if all are additive then yay!
                if(result){
                	System.out.println("You have fulfilled the meaning of life, the universe, and everything with a prime ceiling of "+arg);
                }
                //otherwise boo!!
                else{
                	System.out.println("You have fallen short of the meaning of life, the universe, and everything (or maybe tried too hard) with a prime ceiling of "+arg);
                }
            }
        } catch(Exception e){
        	//print something meaningful in case the user enters an invalid argument or no argument
            System.out.println("Please enter a number greater than 3 since (1) no prime number is less than or equal to 1 and (2) we need to compare at least two prime numbers");
            System.out.println("Usage: java Secret <integer>");
        }
    }

    /**
     * Helper method that determines if all primes less than the ceiling parameter are additive
     * @param ceiling the ceiling that tells us which primes to check (all primes less than this parameter)
     * @return true if all primes are additive and false otherwise
     */
    private static boolean isAdditive(int ceiling){
        System.out.println("Getting all primes less than the ceiling "+ceiling);
        ArrayList<Integer> primes = getPrimes(ceiling);//getting all primes less than the ceiling
        System.out.println(primes.size()+" primes: "+primes);
        int x,y;
        //looping through the list of primes
        for(int i = 0; i < primes.size(); i++){
            x = primes.get(i);
            //loop through all numbers to the right of x to check each combo of x and y
            for(int j = i+1; j < primes.size(); j++){
                y = primes.get(j);
                System.out.println("Comparing "+x+" and "+y);
                
                //check to see if this combo of x and y is additive
                //the first combo that fails will spoil the whole bunch
                if(secret(x+y) != secret(x) + secret(y)){
                	System.out.println("Failed on "+x+" and "+y);
                    return false;
                }
                //otherwise we got a pass for this combo; keep going
                System.out.println("Pass");
            }
        }
        //finally if we never returned false it means all primes in this set have passed the additive test
        return true;
    }

    /**
     * Helper method that gets all primes less than the ceiling parameter
     * @param ceiling the ceiling that tells us which primes to check (all primes less than this parameter)
     * @return a list of primes less than the ceiling
     */
    private static ArrayList<Integer> getPrimes(int ceiling){
        ArrayList<Integer> primes = new ArrayList<Integer>();
        int j;
        for(int i = 2; i < ceiling; i++){
            for(j = 2; j < i; j++){
                if(i % j == 0){
                    //not prime                                                                                                                                                                                                                                                                                               
                    break;
                }
            }
            if(j == i){
                //means this number is prime
                primes.add(i);
            }
        }
        return primes;
    }
    
    /**
     * Helper method that returns the fibonacci sequence less than the ceiling parameter
     * @param ceiling the ceiling that tells us when to stop the fibonacci sequence
     * @return the list of fibonacci sequence numbers less than the ceiling
     */
    private static ArrayList<Integer> fibonacci(int ceiling){
    	int i = 1, j = 1, h;
    	ArrayList<Integer> fibonacci = new ArrayList<Integer>();
    	fibonacci.add(i);
    	fibonacci.add(j);
    	while(j+i < ceiling){
    		h = j;
    		j += i;
    		fibonacci.add(j);
    		i = h;
    	}
    	return fibonacci;
    }
    
    /**
     * || SCROLL
     * ||
     * || DOWN
     * ||
     * || FOR
     * || 
     * || THE
     * ||
     * || SECRET
     * ||
     * ||
     * ||
     * \/
     */
    
    /**
     * THE SECRET METHOD (FUNCTION)!!!
     * @param i the parameter that we need to check
     * @return an integer that represents the outcome of the secret function
     */
    private static int secret(int i){
    	ArrayList<Integer> fibonacci = fibonacci(i);//get fibonacci sequence less than the argument
    	ArrayList<Integer> primes = getPrimes(i);//get primes less than the argument
    	int largestPrime = -1;
    	int primesSize = primes.size();
    	int largestFibonacci = -1;
    	int fibSize = fibonacci.size();
    	if(primes.size() > 0){
    		//get last prime
    		largestPrime = primes.get(primesSize-1);
    	}
    	if(fibonacci.size() > 0){
    		//get last fibonacci sequence number
    		largestFibonacci = fibonacci.get(fibSize-1);
    	}
        if(		i == MEANING_OF_LIFE ||
        		MEANING_OF_LIFE < i && i % MEANING_OF_LIFE == 0 ||
        		MEANING_OF_LIFE > i && MEANING_OF_LIFE % i == 0 ||
        		fibSize != 0 && MEANING_OF_LIFE < largestFibonacci && largestFibonacci % MEANING_OF_LIFE == 0 ||
        		fibSize != 0 && MEANING_OF_LIFE > largestFibonacci && MEANING_OF_LIFE % largestFibonacci == 0 ||
        		fibSize != 0 && MEANING_OF_LIFE < fibSize && fibSize % MEANING_OF_LIFE == 0 ||
        		fibSize != 0 && MEANING_OF_LIFE > fibSize && MEANING_OF_LIFE % fibSize == 0 ||
        		primesSize != 0 && MEANING_OF_LIFE < largestPrime && largestPrime % MEANING_OF_LIFE == 0 ||
        		primesSize != 0 && MEANING_OF_LIFE > largestPrime && MEANING_OF_LIFE % largestPrime == 0 ||
        		primesSize != 0 && MEANING_OF_LIFE < primesSize && primesSize % MEANING_OF_LIFE == 0 ||
        		primesSize != 0 && MEANING_OF_LIFE > primesSize && MEANING_OF_LIFE % primesSize == 0){
        	//we have fulfilled the meaning of life
            return 0;
        }
        else{
        	//we have not fulfilled the meaning of life
        	return 1;
        }
    }
}

