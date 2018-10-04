package exercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * Question: Give a MAX_NUM (> 0), find all prime numbers between 0 to MAX_NUM
 *
 */

public class FindPrimeNumbers {
	
	/**
	 * Approach is to create a boolean array till MAX_NUM and iterate multiples of 
	 * 2, 3 and so on and unset flag of its multiple number. Finally, all set fields
	 * in boolean array will be our answer.
	 * 
	 */
	
	void resetNonPrimeNumbers(Boolean[] primeNumAry) {
		int input = primeNumAry.length-1;
		int max_limit = (int) Math.sqrt(input);
		
		// Handle all even cases here.
		for(int i = 2, j = 2; i*j <= input; j++) {
			primeNumAry[i*j] = false;
		}
		
		// Handle all odd cases.
		for(int i = 3; i <= max_limit; i=i+2) {
			for(int j = 3; j*i <= input; j=j+2) {
				if(primeNumAry[j*i]) {
					primeNumAry[j*i] = false;
				}
			}
		}
		
		primeNumAry[0] = false;
		// number 1 is non-prime.
		primeNumAry[1] = false;
	}
	
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter number upto which prime numbers need to be calculated. ");
		int number = in.nextInt();
		
		FindPrimeNumbers primeNums = new FindPrimeNumbers();
		Boolean[] primeNumAry = new Boolean[number+1];
		Arrays.fill(primeNumAry, true);
		primeNums.resetNonPrimeNumbers(primeNumAry);
		
		System.out.println("Overall prime number found between 0 till " + number + " is " + 
				Arrays.stream(primeNumAry).filter(i->i).count());
		
//		System.out.println("Numbers are : -");
//		for(int i=1; i < number; i++ ) {
//			if(primeNumAry[i]) {
//				System.out.print(i + ",");
//			}
//		}
		in.close();
	}

}
