package p2;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
  
class quickSort {

	public static long m_w = 0 ; 
	public static long m_z = 0 ;
	
	quickSort (long w , long z)
	{
		this.m_w= w;
		this.m_z = z;
	
	}
    public static int partitionArray(long[] arr, int l, int r)
    {
        long x = arr[r];
		int i = l;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= x) {
                // Swapping arr[i] and arr[j]
                long temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
  
                i++;
            }
        }
  
        // Swapping arr[i] and arr[r]
        long temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;
  
        return i;
    }
  
    
    public static long kth_Smallest_Value(long[] arr, int l, int r, int k)
    {
        
        if (k > 0 && k <= r - l + 1) {
           
        	// patition around last element
            int position = partitionArray(arr, l, r);
            
            //if pos == k number return pos
            if (position - l == k - 1)
                return arr[position];
  
            // if pos larger than k recrunce for left part
            if (position - l > k - 1)
                return kth_Smallest_Value(arr, l, position - 1, k);
  
            // if pos smaller than k recurnce for right part
            return kth_Smallest_Value(arr, position + 1, r, k - position + l - 1);
        }
  
        return Integer.MAX_VALUE;
    }
    
    static long get_random()
    {
    	m_z = 36969* (m_z & 65535) + (m_z >> 16);
    	m_w = 18000* (m_w & 65535) + (m_w >> 16);
    	long res = (m_z << 16) + m_w;
    	return res % 1000000000;
    }
    
    public static void main(String[] args)
    {
        //int arr[] = null;
    	/*System.out.println ("Enter you numbers by this order\n"
    			+ "(Size of array).."
    			+ "(k value).."
    			+ "(m_z)).."
    			+ "(m_w)..");*/
    	
        Scanner input= new Scanner(System.in);
        int n = input.nextInt();
        long arr[]= new long[n];
        int k = input.nextInt();
        long w = input.nextInt();
        long z = input.nextInt();
        
        quickSort obj = new quickSort (w, z);
        
        for (int i = 0 ; i<n ; i++)
        {
        	arr[i] = obj.get_random();
        }
        
        kth_Smallest_Value(arr, 0, arr.length - 1, k);
        
        System.out.print (arr[k-1]);
    }
}