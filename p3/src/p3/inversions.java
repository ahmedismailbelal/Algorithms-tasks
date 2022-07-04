package p3;

import java.util.Arrays;
import java.util.Scanner;

public class inversions {
 
    private static int merge_And_Count_inversions(int[] arr, int l,int m, int r)
    {
 
        int[] leftSubarray = Arrays.copyOfRange(arr, l, m + 1);
 
        int[] rightSubarray = Arrays.copyOfRange(arr, m + 1, r + 1);
 
        int i = 0, j = 0, k = l, swaps = 0;
 
        while (i < leftSubarray.length && j < rightSubarray.length) {
            if (leftSubarray[i] <= rightSubarray[j])
                arr[k++] = leftSubarray[i++];
            else {
                arr[k++] = rightSubarray[j++];
                swaps += (m+i) +1;
            }
        }
        
        while (i < leftSubarray.length)
            arr[k++] = leftSubarray[i++];
        while (j < rightSubarray.length)
            arr[k++] = rightSubarray[j++];
        return swaps;
    }
 
    private static int mergeSort_And_Count(int[] arr, int l, int r)
    {
        int count = 0;
 
        if (l < r) {
            int m = (l + r) / 2;
 
            // Total inversion count = left subarray count
            // + right subarray count + merge count
 
            // Left subarray count
            count += mergeSort_And_Count(arr, l, m);
 
            // Right subarray count
            count += mergeSort_And_Count(arr, m + 1, r);
 
            // Merge count
            count += merge_And_Count_inversions(arr, l, m, r);
        }
 
        return count;
    }
 
    // Driver code
    public static void main(String[] args)
    {
        //int[] arr = null;
        Scanner input = new Scanner (System.in);
        System.out.println("Enter your array's size");
        int n = input.nextInt();
        int[] arr = new int [n];
        System.out.println("Enter your numbers");
        for ( int i = 0 ; i < n ; i ++)
        {
        	
        	int s = input.nextInt();
        	arr[i] = s;
        }
 
        System.out.println(
        		mergeSort_And_Count(arr, 0, arr.length - 1));
    }
}
 