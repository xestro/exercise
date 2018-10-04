package exercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * The basic idea is to search the input list for the largest item it contains 
 * and then add it to the end of a growing sorted list. Alternatively, the algorithm 
 * can find the smallest item and move it to the beginning of the growing list.
 *
 */
public class InsertionSort {
	
	public void sortArray(int[] input) {
		if(input.length == 0) return;
		
		for(int i = 1; i < input.length; i++) {
			for(int j = 0; j < i; j++) {
				if(input[j] > input[i]) {
					int temp = input[j];
					input[j] = input[i];
					input[i] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("*************Insertion sort algorithm*************");
		System.out.println("Enter input array (comma separated): ");
		Scanner in = new Scanner(System.in);
		String inStr = in.nextLine().trim();
		int[] inputAry = Arrays.stream(inStr.split(",")).map(k->k.trim()).mapToInt(Integer::parseInt).toArray();
		
		InsertionSort sort = new InsertionSort();
		sort.sortArray(inputAry);
		System.out.print("Output array is: ");
//		Arrays.toString(inputAry);
		Arrays.stream(inputAry).forEach(System.out::println);
		
		in.close();
	}

}
