package exercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * The basic idea is to search the input list for the largest item 
 * it contains and then add it to the end of a growing sorted list. 
 * Alternatively, the algorithm can find the smallest item and move 
 * it to the beginning of the growing list (as implemented below).
 *
 */
public class SelectionSort {
	
	public void sortArray(int[] input) {
		if(input.length == 0) {
			System.out.println("Input array is empty.");
			return;
		}
		
		for(int i=0; i < input.length; i++) {
			int smallest_idx = i;
			for(int j = i; j < input.length; j++) {
				if(input[j] < input[smallest_idx]) {
					smallest_idx = j;
				}
			}
			
			int tmp = input[i];
			input[i] = input[smallest_idx];
			input[smallest_idx] = tmp;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("*************Selection sort algorithm*************");
		System.out.println("Enter input array (comma separated): ");
		Scanner in = new Scanner(System.in);
		String inStr = in.nextLine().trim();
		int[] inputAry = Arrays.stream(inStr.split(",")).map(k->k.trim()).mapToInt(Integer::parseInt).toArray();
		
		SelectionSort sort = new SelectionSort();
		sort.sortArray(inputAry);
		System.out.print("Output array is: ");
//		Arrays.toString(inputAry);
		Arrays.stream(inputAry).forEach(System.out::println);
		
		in.close();
	}

}
