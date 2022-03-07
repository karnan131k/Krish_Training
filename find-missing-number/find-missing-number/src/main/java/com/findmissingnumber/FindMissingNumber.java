package com.findmissingnumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindMissingNumber {

	public int[] arrangeNumberInAssenndingOrder(int arr[]) {
		//bubble sort
		int n = arr.length;
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-i-1; j++) {
				if (arr[j] > arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
	
	public void findMissingNumber(int arr[]) {
		
		int count = 0;
		int missingCount = 0;
		boolean b=false;
		int minssingNumber=0;
		for(int i=0; i<arr.length-1; i++) {
			
			if(arr[i+1] - arr[i] == 1) {
				count++;
			}
			else if(arr[i+1] - arr[i] == 2){
				missingCount++;
				if(missingCount== 1) {
					minssingNumber = (arr[i]+1);
				}
			}else if(arr[i+1] - arr[i] > 2) {
				b=true;
			}
		}
		
		if(count==arr.length-1) {
			System.out.println("your mising number may be " + (arr[0]-1) + " or " + (arr[arr.length-1]+1));
		}else if(missingCount >1 || b) {
			System.out.println("your number sequence is wrong ");
		}else {
			System.out.println("your mising number is "+ minssingNumber);
		}
		
	}

	public static void main(String[] args) throws IOException {

		System.out.println("Enter the sequence with space delimeter ");
		BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
		String[] strNums = bi.readLine().split(" ");
		int num[] = new int[strNums.length];
		for (int i = 0; i < strNums.length; i++) {
            num[i] = Integer.parseInt(strNums[i]);
        }
		FindMissingNumber ob = new FindMissingNumber();
		ob.findMissingNumber(ob.arrangeNumberInAssenndingOrder(num));

	}
}
