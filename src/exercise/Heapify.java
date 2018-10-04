package exercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Q: Given a integer array, convert this into (max) heap.
 * 
 *
 */

public class Heapify {
	
	public void heapify(int[] inputAry) {
		if(inputAry.length == 0) {
			System.out.println("Input array ios empty.");
			return;
		}
		
		for(int i = 0; i < inputAry.length; i++) {
			int index = i;
			while(index != 0) {
				int parentIdx = (index - 1) / 2;
				
				// If parent >= child Then break
				if(inputAry[parentIdx] >= inputAry[index]) {
					break;
				}
				
				// Else swap parent with child
				int tmp = inputAry[parentIdx];
				inputAry[parentIdx] = inputAry[index];
				inputAry[index] = tmp;
				
				// Move to parent and do the same.
				index = parentIdx;
			}
		}
	}
	
	
	public void removeTopItem(int[] inputAry) {
		if(inputAry.length == 0) {
			System.out.println("Cannot remove top element from empty heap.");
			return;
		}
		
		if(inputAry.length == 1) {
			inputAry = new int[0];
			return;
		}
		
		int index = 0;
		int topItem = inputAry[0];
		// Swap last element with top element and then heapify
		inputAry[0] = inputAry[inputAry.length - 1];
		int limitIdx = inputAry.length - 1;
		while(index < inputAry.length) {
			int leftChild = 2 * index + 1;
			int rightChild = 2 * index + 1;
			if( (leftChild > limitIdx && rightChild > limitIdx) ||
					()) {
				
			}
		}
		
		int[] retArray = new int[inputAry.length-1]; 
		System.arraycopy(inputAry, 0, retArray, 0, retArray.length);
		inputAry = retArray;
	}

	public static void main(String[] args) {
		System.out.println("*************Max Heapify*************");
		System.out.println("Enter input array (comma separated): ");
		Scanner in = new Scanner(System.in);
		String inStr = in.nextLine().trim();
		int[] inputAry = Arrays.stream(inStr.split(",")).map(k->k.trim()).mapToInt(Integer::parseInt).toArray();
		
		Heapify heapHandler = new Heapify();
		heapHandler.heapify(inputAry);
		
		System.out.println("Input array after converting to max-heap: ");
		Arrays.stream(inputAry).forEach(i->System.out.print(i + " "));
		
		heapHandler.removeTopItem(inputAry);
		System.out.println("\n\nRemoving top element from max heap. Resulting max-heap becomes: ");
		Arrays.stream(inputAry).forEach(i->System.out.print(i + " "));
		
		in.close();
	}

}
