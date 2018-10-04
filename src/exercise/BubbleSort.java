package exercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * Bubblesort uses the fairly obvious fact that, if an array is not sorted, 
 * it must contain two adjacent elements that are out of order. 
 * The algorithm repeatedly passes through the array, swapping items that 
 * are out of order, until it can't find any more swaps.
 *
 */
public class BubbleSort {
	
	public void sortArray(int[] input) {
		if(input.length == 0) {
			System.out.println("Input array is empty.");
			return;
		}
		
		for(int i=1; i < input.length; i++) {
			if(input[i-1] > input[i]) {
				int tmp = input[i-1];
				input[i-1] = input[i];
				input[i] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("*************Bubble sort algorithm*************");
		System.out.println("Enter input array (comma separated): ");
		Scanner in = new Scanner(System.in);
		String inStr = in.nextLine().trim();
		int[] inputAry = Arrays.stream(inStr.split(",")).map(k->k.trim()).mapToInt(Integer::parseInt).toArray();
		
		BubbleSort sort = new BubbleSort();
		sort.sortArray(inputAry);
		System.out.print("Output array is: ");
//		Arrays.toString(inputAry);
		Arrays.stream(inputAry).forEach(System.out::println);
		
		in.close();
	}
}
